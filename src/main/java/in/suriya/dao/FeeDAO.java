package in.suriya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.suriya.model.BusRequest;
import in.suriya.model.Fee;
import in.suriya.model.SchemeRequest;
import in.suriya.model.ScholarshipRequest;
import in.suriya.model.Student;
import in.suriya.util.ConnectionUtil;

public class FeeDAO {
	
	/**
	 * 
	 * 
	 * @param staff
	 * @return
	 * @throws Exception 
	 */
	public  boolean saveFeeDetails(Fee fee) throws Exception {
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		   connection=ConnectionUtil.getConnection();
		   String sql="insert into fee_details(roll_no,bus,first_graduate,scholarship,govt_scheme) values (?,?,?,?,?)";

		   pst=connection.prepareStatement(sql);
		   pst.setLong(1,fee.getRollNo());
		   pst.setString(2,fee.getBusRequest());
		   pst.setString(3,fee.getFirstGraduateRequest());
		   pst.setString(4,fee.getScholarshipRequest());
		   pst.setString(5,fee.getGovtSchemesRequest());

		   int rows=pst.executeUpdate();
		   if(rows==1) {
		      isSave=true;
		   }
		
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new Exception("you already applied");
		}finally {
		        ConnectionUtil.close(connection,pst);
		}
		
		return isSave;
	}
	
	
	/**
	 * save bus request
	 * 
	 * @param fee
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public  boolean saveBusRequest(long rollNo,String busRoute) throws ClassNotFoundException, SQLException {
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		   connection=ConnectionUtil.getConnection();
		   String sql="insert into bus_request(name,roll_no,mob_no,bus_route) select s.name,s.roll_no,s.mob_no,? from student s where roll_no=?";

		   pst=connection.prepareStatement(sql);
		   pst.setString(1,busRoute);
		   pst.setLong(2,rollNo);
		  

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
	 * save scheme request
	 * 
	 * @param rollNo
	 * @param busRoute
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public  boolean saveSchemeRequest(long rollNo,String scheme) throws ClassNotFoundException, SQLException {
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		   connection=ConnectionUtil.getConnection();
		   String sql="insert into scheme_request(name,roll_no,mob_no,scheme) select s.name,s.roll_no,s.mob_no,? from student s where roll_no=?";

		   pst=connection.prepareStatement(sql);
		   pst.setString(1,scheme);
		   pst.setLong(2,rollNo);
		  

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
	 * save scholarship request
	 * 
	 * @param rollNo
	 * @param scheme
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public  boolean saveScholarshipRequest(long rollNo,int income) throws ClassNotFoundException, SQLException {
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		   connection=ConnectionUtil.getConnection();
		   String sql="insert into scholarship_request(name,roll_no,mob_no,family_income) select s.name,s.roll_no,s.mob_no,? from student s where roll_no=?";
		   		

		   pst=connection.prepareStatement(sql);
		   pst.setInt(1,income);
		   pst.setLong(2,rollNo);
		  

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
	 * get bus Request details
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	 public List<BusRequest> getBusRequestDetails() throws ClassNotFoundException, SQLException {
		    List<BusRequest> busRequestList=new ArrayList<>();
			Connection connection=null;
			Statement st=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
				 
              String sql="select * from bus_request order by roll_no";
              st=connection.createStatement();
	             rs =st.executeQuery(sql);
	             while(rs.next()) {
	            	String name=rs.getString("name");
	                long rollNo=rs.getLong("roll_no");
	                long mobNo=rs.getLong("mob_no");
	                String busRoute=rs.getString("bus_route");

	          
	    		   BusRequest busRequest=new BusRequest();
	    		   busRequest.setName(name);
	    		   busRequest.setRollNo(rollNo);
	    		   busRequest.setMobNo(mobNo);
	    		   busRequest.setBusRoute(busRoute);
	    		   
	    			busRequestList.add(busRequest);
	            	 
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
		
	        return busRequestList;
		
		}
	
	 
	 
	 
	 /**
	  * get scheme request details
	  * 
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public List<SchemeRequest> getSchemeRequestDetails() throws ClassNotFoundException, SQLException {
		    List<SchemeRequest> schemeRequestList=new ArrayList<>();
			Connection connection=null;
			Statement st=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
				 
           String sql="select * from scheme_request order by roll_no";
           st=connection.createStatement();
	             rs =st.executeQuery(sql);
	             while(rs.next()) {
	            	String name=rs.getString("name");
	                long rollNo=rs.getLong("roll_no");
	                long mobNo=rs.getLong("mob_no");
	                String scheme=rs.getString("scheme");

	          
	    		   SchemeRequest schemeRequest=new SchemeRequest();
	    		   schemeRequest.setName(name);
	    		   schemeRequest.setRollNo(rollNo);
	    		   schemeRequest.setMobNo(mobNo);
	    		   schemeRequest.setScheme(scheme);
	    		   
	    			schemeRequestList.add(schemeRequest);
	            	 
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
		
	        return schemeRequestList;
		
		}
	 
	 
	 
	 
	 /**
	  * get scholarship request details
	  * 
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public List<ScholarshipRequest> getScholarshipRequestDetails() throws ClassNotFoundException, SQLException {
		    List<ScholarshipRequest> scholarshipRequestList=new ArrayList<>();
			Connection connection=null;
			Statement st=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
				 
                 String sql="select * from scholarship_request order by family_income";
                 st=connection.createStatement();
	             rs =st.executeQuery(sql);
	             while(rs.next()) {
	            	String name=rs.getString("name");
	                long rollNo=rs.getLong("roll_no");
	                long mobNo=rs.getLong("mob_no");
	                int income=rs.getInt("family_income");

	          
	    		   ScholarshipRequest scholarshipRequest=new ScholarshipRequest();
	    		   scholarshipRequest.setName(name);
	    		   scholarshipRequest.setRollNo(rollNo);
	    		   scholarshipRequest.setMobNo(mobNo);
	    		   scholarshipRequest.setIncome(income);
	    		   
	    			scholarshipRequestList.add(scholarshipRequest);
	            	 
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
		
	        return scholarshipRequestList;
		
		}
	
	 
	 
	 /**
	  * bus request update
	  * 
	  * @param rollNo
	  * @param busRequest
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public boolean busRequestUpdate(long rollNo,String busRequest) throws ClassNotFoundException, SQLException {
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();

			   String sql="update fee_details set bus=? where roll_no=?";
			
			   pst=connection.prepareStatement(sql);
			   pst.setString(1,busRequest);
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
	  * scheme request update
	  * 
	  * @param rollNo
	  * @param busRequest
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public boolean schemeRequestUpdate(long rollNo,String scheme) throws ClassNotFoundException, SQLException {
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();

			   String sql="update fee_details set govt_scheme=? where roll_no=?";
			
			   pst=connection.prepareStatement(sql);
			   pst.setString(1,scheme);
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
	  * scholarship request 
	  * 
	  * @param rollNo
	  * @param scheme
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public boolean scholarshipRequestUpdate(long rollNo,String scholarship) throws ClassNotFoundException, SQLException {
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();

			   String sql="update fee_details set scholarship=? where roll_no=?";
			
			   pst=connection.prepareStatement(sql);
			   pst.setString(1,scholarship);
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
	  * bus request delete 
	  * 
	  * @param rollNo
	  * @param busRequest
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 
	 public boolean busRequestDelete(long rollNo) throws ClassNotFoundException, SQLException {
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();

			   String sql="delete from bus_request where roll_no=?";
			
			   pst=connection.prepareStatement(sql);
			   pst.setLong(1,rollNo);
			   
			
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
	  * scheme request delete
	  * 
	  * @param rollNo
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public boolean schemeRequestDelete(long rollNo) throws ClassNotFoundException, SQLException {
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();

			   String sql="delete from scheme_request where roll_no=?";
			
			   pst=connection.prepareStatement(sql);
			   pst.setLong(1,rollNo);
			   
			
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
	  * scholarship request
	  * 
	  * @param rollNo
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public boolean scholarshipRequestDelete(long rollNo) throws ClassNotFoundException, SQLException {
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();

			   String sql="delete from scholarship_request where roll_no=?";
			
			   pst=connection.prepareStatement(sql);
			   pst.setLong(1,rollNo);
			   
			
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
	  * get bus route
	  * 
	  * @param rollNo
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public String getBusRoute(long rollNo) throws ClassNotFoundException, SQLException {
		    String busRoute=null;
			Connection connection=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
	             String sql="select (bus_route)from bus_request where roll_no=?";
	        
	             pst=connection.prepareStatement(sql);
	             pst.setLong(1, rollNo);
	             
	             rs =pst.executeQuery();
	             while(rs.next()) {
	                   busRoute=rs.getString("bus_route");
	                  
	              }
	             
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(connection,pst,rs);
			
			}
		return busRoute;	
	 }
	 
	 
	 
	 
	 /**
	  * get scheme details
	  * 
	  * @param rollNo
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public String getscheme(long rollNo) throws ClassNotFoundException, SQLException {
		    String scheme=null;
			Connection connection=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
	             String sql="select (scheme)from scheme_request where roll_no=?";
	        
	             pst=connection.prepareStatement(sql);
	             pst.setLong(1, rollNo);
	             
	             rs =pst.executeQuery();
	             while(rs.next()) {
	                   scheme=rs.getString("scheme");
	                  
	              }
	             
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(connection,pst,rs);
			
			}
		return scheme;	
	 }
	 
	 
	 
	 
	 /**
	  * get details fee request details
	  * 
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public List<Fee> getPersonalFeeRequestDetails(long rollNo) throws ClassNotFoundException, SQLException {
		    List<Fee> feeRequestList=new ArrayList<>();
			Connection connection=null;
 			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
				 
                 String sql="select * from fee_details where roll_no=?";
     			 pst=connection.prepareStatement(sql);
	             pst.setLong(1, rollNo);
	             
	             rs =pst.executeQuery();
	             while(rs.next()) {
	            	String busRequest=rs.getString("bus");
	                String firstGraduate=rs.getString("first_graduate");
	                String scholarship=rs.getString("scholarship");
	                String scheme=rs.getString("govt_scheme");

	          
	    		   Fee feeRequest=new Fee();
	    		   feeRequest.setRollNo(rollNo);
	    		   feeRequest.setBusRequest(busRequest);
	    		   feeRequest.setFirstGraduateRequest(firstGraduate);
	    		   feeRequest.setScholarshipRequest(scholarship);
	    		   feeRequest.setGovtSchemesRequest(scheme);
	    		   
	    		   feeRequestList.add(feeRequest);
	    			
	            	 
	            }
	             
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				if(pst!=null) {
					pst.close();
				}
				if(rs!=null) {
					rs.close();
				}
				ConnectionUtil.close(connection);
			
			}
		
	        return feeRequestList;
		
		}
	 
	 
}
