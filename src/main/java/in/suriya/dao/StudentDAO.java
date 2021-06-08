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
	
	
	
	/**
	 * save student into database
	 * 
	 * @param student
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public  boolean saveStudent(Student student) throws ClassNotFoundException, SQLException {
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		    connection=ConnectionUtil.getConnection();
		
		    String sql="insert into student(roll_no,mob_no,fee) values(?,?,?)";
		
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
	
	public boolean deleteStudent(Long rollno) throws ClassNotFoundException, SQLException {
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		    connection=ConnectionUtil.getConnection();
		
		    String sql="delete from student where roll_no=?";
		
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
	public boolean findStudent(Student student) throws ClassNotFoundException, SQLException {
		boolean isValid=false;
		Connection connection=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
		     connection=ConnectionUtil.getConnection();
             String sql="select (roll_no) from student where roll_no=? and mob_no=?";
        
             pst=connection.prepareStatement(sql);
             pst.setLong(1,student.getRollNo());
             pst.setLong(2,student.getMobNo());
        
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
	 * fee structure update
	 * 
	 * @param rollNo
	 * @param feeStructure
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public boolean feeStructureUpdate(long rollNo,int feeStructure) throws ClassNotFoundException, SQLException {
    	boolean isUpdate=false;
    	Connection connection=null;
		PreparedStatement pst=null;
		try {
		   connection=ConnectionUtil.getConnection();

		   String sql="update student set fee_structure=? where roll_no=? ";
		
		   pst=connection.prepareStatement(sql);
		   pst.setInt(1,feeStructure);
		   pst.setLong(2,rollNo);
		   
		
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
	 * update fes and payment details in database
	 * 
	 * @param rollNo
	 * @param fee
	 * @param paymentStatus
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	 public boolean updatePayment(Student student) throws ClassNotFoundException, SQLException {
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();

			   String sql="update student set fee_structure=fee_structure-1, fee=?, payment_status=? where roll_no=? ";
			
			   pst=connection.prepareStatement(sql);
			   pst.setInt(1,student.getFee());
			   pst.setString(2,student.getPaymentDetails());
			   pst.setLong(3,student.getRollNo());
			
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
	  * get fee  and fee structure from database
	  * 
	  * @param rollNo
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 
	
	 public List<Student> getFeeStudent(long rollNo) throws ClassNotFoundException, SQLException {
		    List<Student> studentList=new ArrayList<>();
			Connection connection=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
	             String sql="select * from student where roll_no=?";
	        
	             pst=connection.prepareStatement(sql);
	             pst.setLong(1, rollNo);
	             
	             rs =pst.executeQuery();
	             while(rs.next()) {
	            	  int feeStructure=rs.getInt("fee_structure");
	                  int fee=rs.getInt("fee");
	                  
	                  Student stud=new Student(feeStructure,fee);
		    		  studentList.add(stud);
	             }
	             
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(connection,pst,rs);
			
			}
		
	        return studentList;
		
		}
	
	 
	 /**
	  * get fee from database
	  * 
	  * @param rollNo
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public int getFee(long rollNo) throws ClassNotFoundException, SQLException {
		    int fee=0;
			Connection connection=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
	             String sql="select (fee)from student where roll_no=?";
	        
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
	 public List<Student> getStudentDetails() throws ClassNotFoundException, SQLException {
		    List<Student> studentList=new ArrayList<>();
			Connection connection=null;
			Statement st=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
				 
                 String sql="select * from student order by roll_no";
                 st=connection.createStatement();
	             rs =st.executeQuery(sql);
	             while(rs.next()) {
	                long rollNo=rs.getLong("roll_no");
	                long mobNo=rs.getLong("mob_no");
	                int feeStructure=rs.getInt("fee_structure");
	                int fee=rs.getInt("fee");
	                String paymentStatus=rs.getString("payment_status");

	          
	    			Student stud=new Student(rollNo,mobNo,feeStructure,fee,paymentStatus);
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
	 public List<Student> getPersonalStudentDetails(long rollNo) throws ClassNotFoundException, SQLException {
		    List<Student> studentList=new ArrayList<>();
			Connection connection=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();

	             String sql="select * from student where roll_no=?";
	             pst=connection.prepareStatement(sql);
	             pst.setLong(1, rollNo);
	             
	             rs =pst.executeQuery();
	             while(rs.next()) {
	                long rollNum=rs.getLong("roll_no");
	                long mobNo=rs.getLong("mob_no");
	                int feeStructure=rs.getInt("fee_structure");
	                int fee=rs.getInt("fee");
	                String paymentStatus=rs.getString("payment_status");
	          
	    			Student stud=new Student(rollNum,mobNo,feeStructure,fee,paymentStatus);
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
    
