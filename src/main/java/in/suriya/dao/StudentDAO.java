package in.suriya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.suriya.model.Student;
import in.suriya.util.ConnectionUtil;

public class StudentDAO {
	private StudentDAO() {
		
		}
	
	
	
	/**
	 * save student into database
	 * 
	 * @param student
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public static boolean saveStudent(Student student) throws ClassNotFoundException, SQLException {
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		    connection=ConnectionUtil.getConnection();
		
		    String sql="insert into student(rollno,mobno,fee) values(?,?,?)";
		
		    pst=connection.prepareStatement(sql);
	     	pst.setLong(1,student.getRollNo());
		    pst.setLong(2,student.getMobNo());
		    pst.setInt(3,student.getFee());

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
	 * delete student detail from database
	 * 
	 * @param rollno
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public static boolean deleteStudent(Long rollno) throws ClassNotFoundException, SQLException {
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		    connection=ConnectionUtil.getConnection();
		
		    String sql="delete from student where rollno=?";
		
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1,rollno);

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
	 * find student detail in database
	 * 
	 * @param mobNo
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean findStudent(long rollNo,long mobNo) throws ClassNotFoundException, SQLException {
		boolean isValid=false;
		Connection connection=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
		     connection=ConnectionUtil.getConnection();
             String sql="select * from student where rollno=? and mobno=?";
        
             pst=connection.prepareStatement(sql);
             pst.setLong(1, rollNo);
             pst.setLong(2, mobNo);
        
             rs =pst.executeQuery();
             while(rs.next()) {
                  isValid=true;
             }
             
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(connection,pst,rs);
		
		}
	
        return isValid;
	
	}
	
	/**
	 * update fes and [payment details in database
	 * 
	 * @param rollNo
	 * @param fee
	 * @param paymentStatus
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	 public static boolean updatePayment(long rollNo,int fee,String paymentStatus) throws ClassNotFoundException, SQLException {
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();

			   String sql="update student set fee=?, payment_status=? where rollno=? ";
			
			   pst=connection.prepareStatement(sql);
			   pst.setInt(1,fee);
			   pst.setString(2,paymentStatus);
			   pst.setLong(3,rollNo);
			
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
	    
	 
	 /**
	  * get fee from database
	  * 
	  * @param rollNo
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 
	
	 public static int getFee(long rollNo) throws ClassNotFoundException, SQLException {
			int fee=0;
			Connection connection=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
	             String sql="select (fee)from student where rollno=?";
	        
	             pst=connection.prepareStatement(sql);
	             pst.setLong(1, rollNo);
	             
	             rs =pst.executeQuery();
	             while(rs.next()) {
	                  fee=rs.getInt("fee");
	             }
	             
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(connection,pst,rs);
			
			}
		
	        return fee;
		
		}
	
	 
	 /**
	  * get student table list from database
	  * 
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public static List<Student> getStudentDetails() throws ClassNotFoundException, SQLException {
		    List<Student> studentList=new ArrayList<>();
			Connection connection=null;
			Statement st=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
				 
                 String sql="select *from student order by rollno";
                 st=connection.createStatement();
	             rs =st.executeQuery(sql);
	             while(rs.next()) {
	                long rollNo=rs.getLong("rollno");
	                long mobNo=rs.getLong("mobno");
	                int fee=rs.getInt("fee");
	                String paymentStatus=rs.getString("payment_status");

	          
	    			Student stud=new Student(rollNo,mobNo,fee,paymentStatus);
	    			studentList.add(stud);
	            	 
	            }
	             
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				if(st!=null) {
					st.close();
				}
				if(rs!=null) {
					rs.close();
				}
				ConnectionUtil.close(connection);
			
			}
		
	        return studentList;
		
		}
	
	
	 
	 /**
	  * get individual details from database
	  * 
	  * @param rollNo
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public static List<Student> getPersonalStudentDetails(long rollNo) throws ClassNotFoundException, SQLException {
		    List<Student> studentList=new ArrayList<>();
			Connection connection=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();

	             String sql="select *from student where rollno=?";
	             pst=connection.prepareStatement(sql);
	             pst.setLong(1, rollNo);
	             
	             rs =pst.executeQuery();
	             while(rs.next()) {
	                long rollNum=rs.getLong("rollno");
	                long mobNo=rs.getLong("mobno");
	                int fee=rs.getInt("fee");
	                String paymentStatus=rs.getString("payment_status");
	          
	    			Student stud=new Student(rollNum,mobNo,fee,paymentStatus);
	    			studentList.add(stud);
	            	 
	            }
	             
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(connection,pst,rs);
			
			}
		
	        return studentList;
		
		}
	
	
	
	
	
	
	
}
    
