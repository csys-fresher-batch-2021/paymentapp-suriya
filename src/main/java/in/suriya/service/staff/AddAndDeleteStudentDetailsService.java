package in.suriya.service.staff;


import in.suriya.dao.StudentDAO;
import in.suriya.model.Student;
import in.suriya.util.Validation;

public class AddAndDeleteStudentDetailsService {
	
	StudentDAO studentDao=new StudentDAO();
	
	/**
	 * adds student details
	 * 
	 * @param rollNo
	 * @param mobNo
	 * @param fees
	 * @return
	 * @throws Exception
	 */
	public boolean addStudentDetails(long rollNo,long mobNo,int fee)throws Exception {
		boolean isSuccess=false;
		Validation.mobNoValidater(mobNo);
		Validation.rollNoValidater(rollNo);
        Validation.feeValidater(fee);
        if(fee<50000) throw new Exception("fee should be greater than 50000");
				
		Student stud=new Student(rollNo,mobNo,fee);
        isSuccess=studentDao.saveStudent(stud);

        return isSuccess;
	}
	
	
	
	/**
	 * delete student data 
	 * 
	 * @param rollNo
	 * @return
	 * @throws Exception
	 */
	public boolean deleteStudentDetails(long rollNo) throws Exception {
		boolean isDeleted=false;
		Validation.rollNoValidater(rollNo);
		
		isDeleted=studentDao.deleteStudent(rollNo);
		return isDeleted;
	}

}

