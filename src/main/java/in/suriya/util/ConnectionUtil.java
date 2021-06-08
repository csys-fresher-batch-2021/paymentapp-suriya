package in.suriya.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
    private ConnectionUtil(){
    	
    }
    


    /**
	 * To get the connection from the Data Base.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
    private static String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static String url = System.getenv("spring.datasource.url");
	private static String username = System.getenv("spring.datasource.username");
	private static String password = System.getenv("spring.datasource.password");
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
	
			// Step 1: Load the database driver into memory ( ClassNotFoundException )
			Class.forName(driverClass);
			// Step 2: Get the Database Connection (SQLException)
			connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
    
    
    
	/*public static Connection Connection() throws ClassNotFoundException, SQLException {
		String DriverClass = "org.postgresql.Driver";
		String Url = "jdbc:postgresql://localhost/StudentPaymentApp";
		String DB_username = "postgres";
		String password = "Suriya44**";
		
		Class.forName(DriverClass);
		
		return DriverManager.getConnection(Url, DB_username, password);
	}*/
	
	
	
	/**
	 * To close the connection from the Data Base.
	 * 
	 * @param con
	 */
	public static void close(Connection con,PreparedStatement pst) {
		try {
			if(pst !=null) {
				pst.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con,PreparedStatement pst,ResultSet rs) {
		try {
			
			if(pst !=null) {
				pst.close();
			}
		
		    if(rs !=null) {
			    rs.close();
		    }
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}


