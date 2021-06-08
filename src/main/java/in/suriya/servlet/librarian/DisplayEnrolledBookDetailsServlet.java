package in.suriya.servlet.librarian;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.suriya.model.Book;
import in.suriya.model.EnrolledBook;
import in.suriya.service.librarian.DisplayBookDetailsService;

/**
 * Servlet implementation class DisplayEnrolledBookDetailsServlet
 */
@WebServlet("/DisplayEnrolledBookDetailsServlet")
public class DisplayEnrolledBookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			DisplayBookDetailsService dispBook=new DisplayBookDetailsService();
			List<EnrolledBook> displayEnrolledBookList=dispBook.displayEnrolledBookList();
		
			Gson gson = new Gson();

			String jsonProducts = gson.toJson(displayEnrolledBookList);

			PrintWriter out = response.getWriter();

			out.print(jsonProducts);

			out.flush();

		}catch(Exception e) {
		    response.sendRedirect("librarianoperation.jsp");

		}
	
	}

	

}
