package in.suriya.service.student;

import in.suriya.dao.StudentDAO;
import in.suriya.model.Student;
import in.suriya.util.Validation;

public class StudentLoginService {
	StudentDAO studentDao=new StudentDAO();
    /**
     * checks and validates the credentials
     * @param rollNo
     * @param mobNo
     * @return
     * @throws Exception 
     */
    public boolean studentValidater(long rollNo,long mobNo) throws Exception{
		boolean valid=false;
	    Validation.rollNoValidater(rollNo);
		Validation.mobNoValidater(mobNo);	
		Student stud=new Student(rollNo,mobNo);
		valid=studentDao.findStudent(stud);
		return valid;
	}
}
