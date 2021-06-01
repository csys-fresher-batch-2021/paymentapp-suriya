package in.suriya.servlet.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.service.staff.StaffChangePasswordService;
import in.suriya.util.Validation;
/**
 * Servlet implementation class StaffChangePasswordServlet
 */
@WebServlet("/StaffChangePasswordServlet")
public class StaffChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String currentPassword=request.getParameter("currentPassword");
			String newPassword=request.getParameter("newPassword");
			
			//Validation.passwordValidater(currentPassword);
			
			HttpSession session=request.getSession();
			String pass=(String)session.getAttribute("PASSWORD");
			Long mobNo=(Long)session.getAttribute("STAFF_MOBNO");
			
			if(!pass.equals(currentPassword))throw new Exception("Wrong user Password");
            
			boolean valid=StaffChangePasswordService.changePassword(newPassword,mobNo);
		
			 if (valid) {
				  String message = "password changed sucessfully";
				  session.setAttribute("PASSWORD",newPassword);

				  response.sendRedirect("staffoperation.jsp?infoMessage=" + message);
			  }else {
				  String message = "password already exist";
				  response.sendRedirect("staffchangepassword.jsp?infoMessage=" + message);

			  }
			 
			
			
		}catch(Exception e) {
			String message = e.getMessage();
			  response.sendRedirect("staffchangepassword.jsp?infoMessage=" + message);
		}
		
		
		
	}

	

}
