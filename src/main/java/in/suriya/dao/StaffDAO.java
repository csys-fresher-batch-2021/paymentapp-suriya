package in.suriya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import in.suriya.model.Staff;
import in.suriya.util.ConnectionUtil;

public class StaffDAO {
	private StaffDAO() {
		
	}
	
	
	/**
	 * select staff name for given staff credentials
	 * 
	 * @param mobNo
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public static String findStaff(long mobNo,String password) throws ClassNotFoundException, SQLException {
		String staffName=null;
		Connection connection=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
		   connection=ConnectionUtil.getConnection();
           String sql="select (name) from staff where mobno=? and password=?";
        
           pst=connection.prepareStatement(sql);
           pst.setLong(1, mobNo);
           pst.setString(2, password);
        
           rs =pst.executeQuery();
           while(rs.next()) {
               staffName=rs.getString("name");
             }
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
		        ConnectionUtil.close(connection,pst,rs);
			}
        
		return staffName;
	}
	
	
	/**inserting values into database
	 * 
	 * @param staff
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	
	public static boolean saveStaff(Staff staff) throws ClassNotFoundException, SQLException {
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		   connection=ConnectionUtil.getConnection();
		   String sql="insert into staff(name,mobno,password) values (?,?,?)";

		   pst=connection.prepareStatement(sql);
		   pst.setString(1,staff.getName());
		   pst.setLong(2,staff.getMobNo());
		   pst.setString(3,staff.getPassword());

		   int rows=pst.executeUpdate();
		   if(rows==1) {
		      isSave=true;
		   }
		
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
		        ConnectionUtil.close(connection,pst);
		}
		
		return isSave;
	}
	
	
	/**
	 * 
	 * @param password
	 * @param mobNo
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
    public static boolean updatePassword(String password,Long mobNo) throws ClassNotFoundException, SQLException {
    	boolean isUpdate=false;
    	Connection connection=null;
		PreparedStatement pst=null;
		try {
		   connection=ConnectionUtil.getConnection();

		   String sql="update staff set password=? where mobno=? ";
		
		   pst=connection.prepareStatement(sql);
		   pst.setString(1,password);
		   pst.setLong(2,mobNo);
		
		   int rows=pst.executeUpdate();
	       if(rows==1) {
		       isUpdate=true;
		   }
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}finally {
		        ConnectionUtil.close(connection,pst);
		}
		
		return isUpdate;
    }
    
}
