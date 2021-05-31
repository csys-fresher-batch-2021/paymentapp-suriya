package in.suriya.servlet.staff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.service.staff.StaffLoginAndRegisterService;

/**
 * Servlet implementation class StaffRegisterServlet
 */
@WebServlet("/StaffRegisterServlet")
public class StaffRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			  String staffName=request.getParameter("staffName");
			  Long mobileNo =Long.parseLong(request.getParameter("mobileNo"));
			  String password = request.getParameter("password");
			 
			  boolean valid = StaffLoginAndRegisterService.registerStaff(staffName,mobileNo, password);
              
			  if (valid) {
				  HttpSession session=request.getSession();
				  session.setAttribute("LOGGED_IN_STAFF",staffName);
				  session.setAttribute("PASSWORD",password);
				  session.setAttribute("STAFF_MOBNO",mobileNo);

				  
				  String message = "succesfully Registered"+staffName;
				  response.sendRedirect("staffoperation.jsp?infoMessage=" + message);
			  }else {
				  String message = "Already Exist";
				  response.sendRedirect("staffregister.jsp?infoMessage=" + message);
				  }
			  
			  
		  }catch(Exception e) {
				String message = e.getMessage();
				response.sendRedirect("staffregister.jsp?errorMessage=" + message);
				
			}
		
		
	}

	

}
