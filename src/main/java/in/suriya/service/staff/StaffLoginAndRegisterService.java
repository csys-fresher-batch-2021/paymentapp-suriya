package in.suriya.service.staff;

import in.suriya.model.Staff;
import in.suriya.util.Validation;
import in.suriya.dao.StaffDAO;

public class StaffLoginAndRegisterService {
	
	   StaffDAO staffDao=new StaffDAO();
	   
	   /**checks and validates for credentials
	    * 
	    * @param mobNo
	    * @param password
	    * @return
	 * @throws Exception 
	    */
	    
		public String staffValidater(long mobNo, String password) throws Exception {
	    String staffName=null;
		Validation.mobNoValidater(mobNo);
		Validation.passwordValidater(password);
		
		Staff st = new Staff(mobNo,password);
		staffName=staffDao.findStaff(st);

		return staffName;
	}
		
	

		/**
		 * 
		 * @param mobNo
		 * @param password
		 * @return
		 * @throws Exception 
		 */
		
		
		public  boolean registerStaff(String name,long mobNo, String password) throws Exception {
		   
			boolean isSuccess = false;
			Validation.mobNoValidater(mobNo);
			Validation.passwordValidater(password);
			Staff st = new Staff(name,mobNo,password);
			
			isSuccess= staffDao.saveStaff(st);
			
			return isSuccess;
		}
		
		
		
		
	
	
	
	
	
}
