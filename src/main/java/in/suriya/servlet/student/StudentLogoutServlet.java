package in.suriya.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentLogoutServlet
 */
@WebServlet("/StudentLogoutServlet")
public class StudentLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	    	HttpSession session=request.getSession();
			session.setAttribute("LOGGED_IN_STUDENT",null);
			response.sendRedirect("studentlogin.jsp?");
		}catch(Exception e) {
			System.out.println("session not removed");
		}
	}
}
