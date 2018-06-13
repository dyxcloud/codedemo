package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import org.junit.Test;

public class MySqlDemo {


	@Test
	public void queryTest() throws Exception  {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/day02";
		Connection conn = DriverManager.getConnection(url, "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from ta");
		while(rs.next()){
			int cid = rs.getInt("id");
			int cname = rs.getInt("num");
			System.out.println(cid + " , " + cname);
		}
		rs.close();
		stmt.close();
		conn.close();
	}
	
	public void insertBatchTest() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/day02";
		Connection conn = DriverManager.getConnection(url, "root", "root");
		String sql = "insert into ta values(5,999);";
		String sql2 = "nsert into ta values(6,233);";
		Statement statement = conn.createStatement();
		statement.addBatch(sql);
		statement.addBatch(sql2);
		int[] batch = statement.executeBatch();//出现异常不会回滚
		System.out.println(Arrays.toString(batch));
		statement.close();
		conn.close();
	}
	
	public void insertNullTest() throws Exception  {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/day02";
		Connection conn = DriverManager.getConnection(url, "root", "root");
		String sql="insert into ta values(?,?,?,?)";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setObject(1, 4);
		prepareStatement.setObject(2, null);
		prepareStatement.setString(3, null);
		prepareStatement.setObject(4, null);
		int update = prepareStatement.executeUpdate();
		System.out.println(update);
		conn.close();
	}
	
	@Test
	public void autoCommitTest() throws Exception {
	       Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/day02";
	        Connection conn = DriverManager.getConnection(url, "root", "root");
	        conn.setAutoCommit(false);
	        
	        String sql="insert into ta values(?,?,?,?)";
	        PreparedStatement prepareStatement = conn.prepareStatement(sql);
	        prepareStatement.setObject(1, 5);
	        prepareStatement.setObject(2, null);
	        prepareStatement.setString(3, null);
	        prepareStatement.setObject(4, null);
	        int update = prepareStatement.executeUpdate();
	        System.out.println(update);
	        
	        conn.setAutoCommit(true);
	        conn.close();
	}
	
	
}
