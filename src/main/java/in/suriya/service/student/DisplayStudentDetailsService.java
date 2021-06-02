package in.suriya.service.student;

import java.sql.SQLException;
import java.util.List;

import in.suriya.dao.StudentDAO;
import in.suriya.model.Student;

public class DisplayStudentDetailsService {

	
	 /**
     * get details from studentDAO
     * 
     * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
     */
	
    public static List<Student> displayStudentList() throws ClassNotFoundException, SQLException{
    	List<Student> studList=StudentDAO.getStudentDetails();
    	return studList;
    }
    
    
    
   
	/**display particular student details
	 * 
	 * @param rollNo
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static List<Student>  displayPersonalDetails(String rollNo) throws ClassNotFoundException, SQLException{
		long rollNum=Long.parseLong(rollNo);
    	List<Student> personalDetails = StudentDAO.getPersonalStudentDetails(rollNum);	
    	return personalDetails;
    }
    
}
