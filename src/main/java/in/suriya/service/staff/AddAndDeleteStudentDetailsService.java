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
	public boolean addStudentDetails(String name,long rollNo,long mobNo,int fee,String location)throws Exception {
		boolean isSuccess=false;
		Validation.mobNoValidater(mobNo);
		Validation.rollNoValidater(rollNo);
		
		Student stud=new Student(name,rollNo,mobNo,fee,location);
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

