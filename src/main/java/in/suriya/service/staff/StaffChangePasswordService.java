package in.suriya.service.staff;


import in.suriya.dao.StaffDAO;
import in.suriya.util.Validation;

public class StaffChangePasswordService {

	
	
	public static boolean changePassword(String newPassword,long mobNo) throws Exception {
		boolean isvalid=false;
		Validation.passwordValidater(newPassword);		
		isvalid=StaffDAO.updatePassword(newPassword,mobNo);
		return isvalid;
	}

}
