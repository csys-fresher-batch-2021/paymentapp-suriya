package in.suriya.servlet.librarian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LibrarianLogoutServlet
 */
@WebServlet("/LibrarianLogoutServlet")
public class LibrarianLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session=request.getSession();
			session.setAttribute("LOGGED_IN_LIBRARIAN",null);
			response.sendRedirect("librarianlogin.jsp?");		
		}catch(Exception e){
			System.out.println("Session not removed");
		}
	}
}
