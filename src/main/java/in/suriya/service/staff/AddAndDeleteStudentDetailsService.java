package in.suriya.service.staff;

import in.suriya.dao.StudentDAO;
import in.suriya.model.Student;
import in.suriya.util.Validation;

public class AddAndDeleteStudentDetailsService {

	
	/**
	 * adds student details
	 * 
	 * @param rollNo
	 * @param mobNo
	 * @param fees
	 * @return
	 * @throws Exception
	 */
	public static boolean addStudentDetails(long rollNo,long mobNo,int fee)throws Exception {
		boolean isSuccess=false;
		Validation.mobNoValidater(mobNo);
		Validation.rollNoValidater(rollNo);
        Validation.feeValidater(fee);
				
		Student stud=new Student(rollNo,mobNo,fee);
        isSuccess=StudentDAO.saveStudent(stud);

        return isSuccess;
	}
	
	
	
	/**
	 * delete student data 
	 * 
	 * @param rollNo
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteStudentDetails(long rollNo) throws Exception {
		boolean isDeleted=false;
		Validation.rollNoValidater(rollNo);
		
		isDeleted=StudentDAO.deleteStudent(rollNo);
		return isDeleted;
	}

}

