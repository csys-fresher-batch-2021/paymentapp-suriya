package in.suriya.servlet.staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.model.Student;
import in.suriya.service.student.DisplayStudentDetailsService;

/**
 * Servlet implementation class DisplayStudentDetailsServlet
 */
@WebServlet("/DisplayStudentDetailsServlet")
public class DisplayStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
		List<Student> displayAllStudentList=DisplayStudentDetailsService.displayStudentList();
		HttpSession session=request.getSession();
		session.setAttribute("STUDENT_LIST",displayAllStudentList);
	    response.sendRedirect("displayallstudentdetails.jsp");

	}catch(Exception e) {
		String message = e.getMessage();
	    response.sendRedirect("staffoperation.jsp?infoMessage="+message);

	}
	
	
	
	}

	
}
