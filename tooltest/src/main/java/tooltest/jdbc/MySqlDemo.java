package tooltest.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Arrays;

public class MySqlDemo {


    @Test
    public void queryTest() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/localweb";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
        while (rs.next()) {
            int no = rs.getInt("id");
            String name = rs.getString("username");
            int age = rs.getInt("age");
            System.out.println(no + " , " + name + " , " + age);
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void quertInTest() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/localweb";
        try (Connection conn = DriverManager.getConnection(url, "root", "root");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from user where age in (12,13)");) {
            while (rs.next()) {
                int no = rs.getInt("id");
                String name = rs.getString("username");
                int age = rs.getInt("age");
                System.out.println(no + " , " + name + " , " + age);
            }
        }
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

    public void insertNullTest() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day02";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        String sql = "insert into ta values(?,?,?,?)";
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

        String sql = "insert into ta values(?,?,?,?)";
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
