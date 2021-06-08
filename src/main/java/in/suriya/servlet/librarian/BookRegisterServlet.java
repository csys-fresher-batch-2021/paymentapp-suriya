package in.suriya.servlet.librarian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.service.librarian.BookRegisterService;
import in.suriya.service.staff.StaffChangePasswordService;
import in.suriya.util.Validation;

/**
 * Servlet implementation class BookRegisterServlet
 */
@WebServlet("/BookRegisterServlet")
public class BookRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 int bookId=Validation.parseInt(request.getParameter("bookId"),"Invalid bookId");
			 long rollNo = Validation.parseLong(request.getParameter("rollNo"), "Invalid Roll number");

			 BookRegisterService register=new BookRegisterService();
			 boolean valid=register.enrollBook(bookId, rollNo);
		
			 if (valid) {
				  String message = "book registered sucessfully";
                  response.sendRedirect("librarianoperation.jsp?infoMessage=" + message);
			  }else {
				  String message = "you already bought this book or invalid book id or invalid roll number";
				  response.sendRedirect("registerbook.jsp?errorMessage=" + message);

			  }
			 
	}catch(Exception e) {
			  response.sendRedirect("registerbook.jsp?errorMessage=" + e.getMessage());
		}
		
	
	
	
	}

	

}
