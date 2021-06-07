package in.suriya.servlet.librarian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.service.librarian.LibrarianLoginService;
import in.suriya.util.Validation;

/**
 * Servlet implementation class LibrarianLoginServlet
 */
@WebServlet("/LibrarianLoginServlet")
public class LibrarianLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String userName=request.getParameter("userName");
	        String password = request.getParameter("password");
	          
	          
			  boolean valid = LibrarianLoginService.librarianValidater(userName,password);
	          
			  if (valid) {
				  HttpSession session=request.getSession();
				  session.setAttribute("LOGGED_IN_LIBRARIAN",userName);
				  
				  String message = "succesfully Logged in"+userName;
				  response.sendRedirect("librarianoperation.jsp?infoMessage=" + message);
				  
			  }else {
				
				  response.sendRedirect("librarianlogin.jsp?errorMessage=invalid Login Credentials");
				  
			  }
			}catch(Exception e) {
				
				response.sendRedirect("librarianlogin.jsp?errorMessage="+e.getMessage() );
				
			}
			
	
	
	}

	

}
