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
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String DriverClass = "org.postgresql.Driver";
		String Url = "jdbc:postgresql://localhost/StudentPaymentApp";
		String DB_username = "postgres";
		String password = "Suriya44**";
		
		Class.forName(DriverClass);
		
		return DriverManager.getConnection(Url, DB_username, password);
	}
	
	
	
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


