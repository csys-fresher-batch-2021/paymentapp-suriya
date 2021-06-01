package in.suriya.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.service.student.StudentLoginService;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			long rollNo=Long.parseLong(request.getParameter("rollNo"));
			long MobNo=Long.parseLong(request.getParameter("mobileNumber"));
			boolean Valid=StudentLoginService.studentValidater(rollNo, MobNo);			
		
			if(Valid) {
				 HttpSession session=request.getSession();
				 session.setAttribute("LOGGED_IN_STUDENT",String.valueOf(rollNo));
				 
				 String message = "sucessfully logged in";
				 response.sendRedirect("studentoperation.jsp?infoMessage=" + message);

			}else {
				String message = "invalid Login Credentials";
				response.sendRedirect("studentlogin.jsp?infoMessage=" + message);
			}
			
			
			
		}catch(Exception e) {
			String message = e.getMessage();
			response.sendRedirect("studentlogin.jsp?infoMessage=" + message);
			
		}
		
		
		
	}

	

}
