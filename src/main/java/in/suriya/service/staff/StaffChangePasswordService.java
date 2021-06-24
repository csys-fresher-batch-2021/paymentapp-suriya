package in.suriya.service.staff;


import in.suriya.dao.StaffDAO;
import in.suriya.model.Staff;
import in.suriya.util.Validation;

public class StaffChangePasswordService {
	StaffDAO staffDao=new StaffDAO();
	/**
	 * change password for staff
	 * @param newPassword
	 * @param mobNo
	 * @return
	 * @throws Exception
	 */
	public boolean changePassword(String newPassword,long mobNo) throws Exception {
		boolean isvalid=false;
		Validation.passwordValidater(newPassword);		
		Staff st=new Staff(mobNo,newPassword);
		isvalid=staffDao.updatePassword(st);
	 return isvalid;
	}

}
