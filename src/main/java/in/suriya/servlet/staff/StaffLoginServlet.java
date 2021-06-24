package in.suriya.servlet.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.dao.StaffDAO;
import in.suriya.service.staff.StaffLoginAndRegisterService;
import in.suriya.util.Validation;

/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/StaffLoginServlet")
public class StaffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalArgumentException {
		try{
		  long mobileNumber = Validation.parseLong(request.getParameter("mobileNo"), "Invalid Mobile number");
          String password = request.getParameter("password");
          StaffLoginAndRegisterService login=new StaffLoginAndRegisterService();
		  String staffName = login.staffValidater(mobileNumber,password);
          if(staffName!=null){
			  HttpSession session=request.getSession();
			  session.setAttribute("LOGGED_IN_STAFF",staffName);
			  session.setAttribute("PASSWORD",password);
			  session.setAttribute("STAFF_MOBNO",mobileNumber);
			  String message= "succesfully Logged in"+staffName;
			  response.sendRedirect("staffoperation.jsp?infoMessage=" + message);
		  }else {
			  response.sendRedirect("stafflogin.jsp?errorMessage=invalid Login Credentials");
		   }
		}catch(Exception e) {
			response.sendRedirect("stafflogin.jsp?errorMessage="+e.getMessage());
		 }
	}
}

	


