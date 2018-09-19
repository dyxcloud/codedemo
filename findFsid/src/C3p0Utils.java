import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class C3p0Utils {

	private static DataSource dataSource=new ComboPooledDataSource();
	private static DataSource tempDS = new ComboPooledDataSource("temp");
	
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

	public static Connection getConnectionForTemp(){
		try {
			return tempDS.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		for(int i =0;i<40;i++){
			Connection con=C3p0Utils.getConnection();
			System.out.println("获取到的"+con);
			con.close();
		}
	}
}
