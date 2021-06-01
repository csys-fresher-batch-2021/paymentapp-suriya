package in.suriya.servlet.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.suriya.service.staff.AddAndDeleteStudentDetailsService;
import in.suriya.util.Validation;

/**
 * Servlet implementation class DeleteStudentDetailsServlet
 */
@WebServlet("/DeleteStudentDetailsServlet")
public class DeleteStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 long rollNo = Validation.parseLong(request.getParameter("rollNo"), "Invalid Roll number");

			boolean valid=AddAndDeleteStudentDetailsService.deleteStudentDetails(rollNo);
		
			 if (valid) {
				  String message = "Student Entry Deleted Sucessfully";
				  response.sendRedirect("staffoperation.jsp?infoMessage=" + message);
			  }else {
				  String message = "Student Details does not Exist";
				  response.sendRedirect("deletestudentdetails.jsp?infoMessage=" + message);
				  }
			
			
			
		}catch(Exception e) {
			String message = e.getMessage();
			  response.sendRedirect("deletestudentdetails.jsp?infoMessage=" + message);
		}

	
	
	
	
	}

	

}
