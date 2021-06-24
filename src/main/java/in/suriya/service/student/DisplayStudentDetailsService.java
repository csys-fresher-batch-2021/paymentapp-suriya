package in.suriya.service.student;

import java.sql.SQLException;
import java.util.List;

import in.suriya.dao.FeeDAO;
import in.suriya.dao.StudentDAO;
import in.suriya.model.Fee;
import in.suriya.model.Student;

public class DisplayStudentDetailsService {
	StudentDAO studentDao=new StudentDAO();
	FeeDAO feeDao=new FeeDAO();
	 /**
     * get details from studentDAO 
     * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
     */
    public List<Student> displayStudentList() throws ClassNotFoundException, SQLException{
    	return studentDao.getStudentDetails();
    }
    /**
     * display particular student details
	 * @param rollNo
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Student>  displayPersonalDetails(String rollNo) throws ClassNotFoundException, SQLException{
		long rollNum=Long.parseLong(rollNo); 	
    	return studentDao.getPersonalStudentDetails(rollNum);
    }
	/**
	 * display fee request details 
	 * @param rollNo
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Fee>  displayPersonalFeeDetails(String rollNo) throws ClassNotFoundException, SQLException{
		long rollNum=Long.parseLong(rollNo); 	
    	return feeDao.getPersonalFeeRequestDetails(rollNum);
    }
}
