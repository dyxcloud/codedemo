package cn.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3p0Utils {

	private static DataSource dataSource=new ComboPooledDataSource();

	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return con;
	}

	public static void main(String[] args) throws SQLException, InterruptedException {
		for(int i =0;i<40;i++){
			Connection con=C3p0Utils.getConnection();
			System.out.println("获取到的"+con);
			con.close();
		}

		/*ComboPooledDataSource ds = (ComboPooledDataSource)dataSource;
		int i=0;
		while(i++<10){
			System.out.println("--------------------------");
			System.out.println(ds.getMaxPoolSize());// 最大连接数
			System.out.println(ds.getMinPoolSize());// 最小连接数
			System.out.println(ds.getNumBusyConnections());// 正在使用连接数
			System.out.println(ds.getNumIdleConnections());// 空闲连接数
			System.out.println(ds.getNumConnections());// 总连接数
			Thread.sleep(3000);
		}*/
	}
}
