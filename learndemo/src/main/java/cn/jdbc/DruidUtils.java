package cn.jdbc;


import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author DongYunxiang
 * @create 2019-01-21
 **/
public class DruidUtils {

    private static DruidDataSource dataSource = new DruidDataSource();

    static {
        try {
            GetDbConnectSSO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() throws Exception {
        return dataSource;
    }

    private static void GetDbConnectSSO() throws Exception {
        if (dataSource == null) {
            //设置连接参数
            dataSource.setUrl("jdbc:mysql://192.168.200.128:3306/test");
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            //配置初始化大小、最小、最大
            dataSource.setInitialSize(1);
            dataSource.setMinIdle(1);
            dataSource.setMaxActive(20);
            //连接泄漏监测
            dataSource.setRemoveAbandoned(true);
            dataSource.setRemoveAbandonedTimeout(30);
            //配置获取连接等待超时的时间
            dataSource.setMaxWait(20000);
            //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
            dataSource.setTimeBetweenEvictionRunsMillis(20000);
            //防止过期
            dataSource.setValidationQuery("SELECT 1");
            dataSource.setTestWhileIdle(true);
            dataSource.setTestOnBorrow(true);
        }
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

    public static void main(String[] args) throws Exception {
        DataSource dataSource = getDataSource();
        for(int i =0;i<40;i++){
            Connection con=C3p0Utils.getConnection();
            System.out.println("获取到的"+con);
            con.close();
        }
    }
}
