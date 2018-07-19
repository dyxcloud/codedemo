package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Db2Demo {

    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:db2://10.50.1.29:50002/EDOCSYSA";
        String sql = "select no as sid,'123' as col1 from ADM_BATCH_NOTICE fetch first 10 rows only for read only with ur";
        Class.forName("com.ibm.db2.jcc.DB2Driver");// 加载驱动
        try (Connection conn = DriverManager.getConnection(url, "edocefs", "123456"); // 获得连接
                Statement statement = conn.createStatement(); // 获得执行对象
                ResultSet resultSet = statement.executeQuery(sql);// 执行sql语句
        ) {
            while (resultSet.next()) {// 处理结果集
                    System.out.print(resultSet.getString("sid") + "\t");
                    System.out.print(resultSet.getString("col1") + "\t");
                System.out.println();
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
