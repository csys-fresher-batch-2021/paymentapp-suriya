package in.suriya.servlet.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StaffLogoutServlet
 */
@WebServlet("/StaffLogoutServlet")
public class StaffLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			HttpSession session=request.getSession();
			session.setAttribute("LOGGED_IN_STAFF",null);
			response.sendRedirect("stafflogin.jsp?");
			
		}catch(Exception e){
			System.out.println("Session not removed");
		}
		
		
		
		
	}

	
	

}
