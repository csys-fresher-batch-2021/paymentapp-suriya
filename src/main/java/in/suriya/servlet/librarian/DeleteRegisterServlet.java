package in.suriya.servlet.librarian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.suriya.service.librarian.BookRegisterService;
import in.suriya.util.Validation;

/**
 * Servlet implementation class deleteRegisterServlet
 */
@WebServlet("/DeleteRegisterServlet")
public class DeleteRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 int bookId=Validation.parseInt(request.getParameter("bookId"),"Invalid bookId");
			 long rollNo = Validation.parseLong(request.getParameter("rollNo"), "Invalid Roll number");
			 BookRegisterService  deleteRegister=new BookRegisterService();    
			 boolean valid=deleteRegister.deleteEnrollBook(bookId, rollNo);
			 if (valid) {
				  String message = "book register deleted sucessfully";
                  response.sendRedirect("librarianoperation.jsp?infoMessage=" + message);
			  }else {
				  String message = "entry not found or invalid book id or invalid roll number";
				  response.sendRedirect("deregisterbook.jsp?errorMessage=" + message);
				  }
	     }catch(Exception e) {
			  response.sendRedirect("registerbook.jsp?errorMessage=" + e.getMessage());
		   }
	}
}
