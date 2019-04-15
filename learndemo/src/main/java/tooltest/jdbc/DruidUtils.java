package tooltest.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author DongYunxiang
 * @create 2019-01-21
 **/
public class DruidUtils {

    private static DruidDataSource druidDataSource = null;

    static {
        Properties prop = new Properties();
        try (InputStream in = String.class.getResourceAsStream("/druid.properties")) {
            prop.load(in);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DruidPooledConnection getConnection() throws SQLException {
        return druidDataSource.getConnection();
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 40; i++) {
            Connection con = DruidUtils.getConnection();
            System.out.println("获取到的" + con);
            con.close();
        }
    }
}
