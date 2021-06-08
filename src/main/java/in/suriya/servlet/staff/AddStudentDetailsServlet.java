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
 * Servlet implementation class AddStudentDetailsServlet
 */
@WebServlet("/AddStudentDetailsServlet")
public class AddStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			 long rollNo = Validation.parseLong(request.getParameter("rollNo"), "Invalid Roll number");
			 long mobNo = Validation.parseLong(request.getParameter("mobileNo"), "Invalid Mobile number");
			 int fee=Validation.parseInt(request.getParameter("fee"),"Invalid Fee");
			 
			 AddAndDeleteStudentDetailsService addStudent=new AddAndDeleteStudentDetailsService();
			
            
			boolean valid=addStudent.addStudentDetails(rollNo, mobNo, fee);
		
			 if (valid) {
				  String message = "Student Entry Added Sucessfully";
				  response.sendRedirect("staffoperation.jsp?infoMessage=" + message);
			  }else {
				  response.sendRedirect("addstudentdetails.jsp?errorMessage=Already Exist");
				  }
			
			
			
		}catch(Exception e) {
			  response.sendRedirect("addstudentdetails.jsp?errorMessage=" + e.getMessage());
		}
		
	
	
	
	}

	

}
