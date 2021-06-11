package in.suriya.service.student;

import java.sql.SQLException;
import java.util.List;

import in.suriya.dao.FeeDAO;
import in.suriya.dao.StudentDAO;
import in.suriya.model.BusRequest;
import in.suriya.model.SchemeRequest;
import in.suriya.model.ScholarshipRequest;

public class DisplayRequestDetailsService {

	FeeDAO feeDao=new FeeDAO();
	StudentDAO studentDao=new StudentDAO();
	/**
	 * get bus request details
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<BusRequest> displayBusRequestList() throws ClassNotFoundException, SQLException{
    	return feeDao.getBusRequestDetails();
    }
	
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public  boolean busRequestUpdate(String rollNo,String requestStatus) throws ClassNotFoundException, SQLException{
	 boolean isUpdate=false;
	 long rollNum=Long.parseLong(rollNo);
	
	
     feeDao.busRequestUpdate(rollNum,requestStatus);
     
     
     if(requestStatus.equalsIgnoreCase("Approved")) {
    	 
    	
        int fee=studentDao.getFee(rollNum);
       
        String busRoute=feeDao.getBusRoute(rollNum);
        
        if(busRoute.equals("tirunelveli")) {
        	fee=fee+8000;
        }
        if(busRoute.equals("madurai")) {
        	fee=fee+10000;
        }
        if(busRoute.equals("tuticorin")) {
        	fee=fee+12000;
        }
   	 
        studentDao.setFee(rollNum, fee);
     }
     
     feeDao.busRequestDelete(rollNum);
     
     return isUpdate;
    }
	
	
	/**
	 * get scheme request details
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<SchemeRequest> displaySchemeRequestList() throws ClassNotFoundException, SQLException{
    	return feeDao.getSchemeRequestDetails();
    }
	
	
	
	/**
	 * scheme reqest update
	 * 
	 * @param rollNo
	 * @param requestStatus
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean schemeRequestUpdate(String rollNo,String requestStatus) throws ClassNotFoundException, SQLException{
		 boolean isUpdate=false;
		 long rollNum=Long.parseLong(rollNo);
		 
	     feeDao.schemeRequestUpdate(rollNum,requestStatus);
	     
	     
	     if(requestStatus.equals("Approved")) {
	    	 
	    	 int fee=studentDao.getFee(rollNum);
	         
	         String scheme=feeDao.getscheme(rollNum);
	         
	         if(scheme.equals("Prime Minister Special Scholarship Scheme (PMSSS), Assam")) {
	         	fee=fee-(fee*40/100);
	         }else {
	        	 fee=fee-(fee*60/100);
	         }
	         
	         studentDao.setFee(rollNum, fee);
	    	 
	    	 
	     }
	     feeDao.schemeRequestDelete(rollNum);
	     return isUpdate;
	    }
	
	/**
	 * get scholarship request details
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ScholarshipRequest> displayScholarshipRequestList() throws ClassNotFoundException, SQLException{
    	return feeDao.getScholarshipRequestDetails();
    }
	
	
	
	/**
	 * scholarship request details
	 * 
	 * @param rollNo
	 * @param requestStatus
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean scholarshipRequestUpdate(String rollNo,String requestStatus) throws ClassNotFoundException, SQLException{
		 boolean isUpdate=false;
		 long rollNum=Long.parseLong(rollNo);
		 
		 
	     feeDao.scholarshipRequestUpdate(rollNum,requestStatus);
	     if(requestStatus.equals("Approved")) {
             
	    	 int fee=studentDao.getFee(rollNum);
	    	 fee=fee-(fee*10/100);
	    	 
	         studentDao.setFee(rollNum, fee);
	    	 
	     }
	     feeDao.scholarshipRequestDelete(rollNum);
	     
	     return isUpdate;
	    }
}
