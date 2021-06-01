package in.suriya.service.student;

import in.suriya.dao.StudentDAO;
import in.suriya.util.Validation;

public class StudentLoginService {
	private StudentLoginService() {
		//default constructor
	}

    
    
    
    /**checks and validates the credentials
     * 
     * @param rollNo
     * @param mobNo
     * @return
     * @throws Exception 
     */
    
     public static boolean studentValidater(long rollNo,long mobNo) throws Exception{
		boolean valid=false;
	    Validation.rollNoValidater(rollNo);
		Validation.mobNoValidater(mobNo);
		valid=StudentDAO.findStudent(rollNo, mobNo);
		
		return valid;
	}
    
    
	

}
