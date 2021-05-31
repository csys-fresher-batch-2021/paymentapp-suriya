package in.suriya.service.staff;

import in.suriya.model.Staff;
import in.suriya.util.Validation;
import in.suriya.dao.StaffDAO;

public class StaffLoginAndRegisterService {
	    private StaffLoginAndRegisterService() {
	    	//Default constructor
	    }
	
	  
	   
	   
	   
	   /**checks and validates for credentials
	    * 
	    * @param mobNo
	    * @param password
	    * @return
	 * @throws Exception 
	    */
	    
		public static String staffValidater(long mobNo, String password) throws Exception {
		String staffName=null;
		Validation.mobNoValidater(mobNo);
		Validation.passwordValidater(password);
		
		staffName=StaffDAO.findStaff(mobNo,password);
		
		return staffName;
	}
		
	

		/**
		 * 
		 * @param mobNo
		 * @param password
		 * @return
		 * @throws Exception 
		 */
		
		
		public static boolean registerStaff(String name,long mobNo, String password) throws Exception {
			boolean isSuccess = false;
			Validation.mobNoValidater(mobNo);
			Validation.passwordValidater(password);
			Staff st = new Staff(name,mobNo,password);
			isSuccess= StaffDAO.saveStaff(st);
			
			return isSuccess;
		}
		
		
		
		
	
	
	
	
	
}
