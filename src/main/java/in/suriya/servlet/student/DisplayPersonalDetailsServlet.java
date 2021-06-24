package in.suriya.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.model.EnrolledBook;
import in.suriya.model.Student;
import in.suriya.service.librarian.DisplayBookDetailsService;
import in.suriya.service.student.DisplayStudentDetailsService;

/**
 * Servlet implementation class DisplayPersonalDetailsServlet
 */
@WebServlet("/DisplayPersonalDetailsServlet")
public class DisplayPersonalDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session=request.getSession();
			String rollNo=(String)session.getAttribute("LOGGED_IN_STUDENT");
			DisplayStudentDetailsService dispStudent=new DisplayStudentDetailsService();
			List<Student> displayPersonalDetails=dispStudent.displayPersonalDetails(rollNo);
			DisplayBookDetailsService dispBook=new DisplayBookDetailsService();
			List<EnrolledBook> displayPersonalEnrolledBookList=dispBook.displayPersonalEnrolledBookList(rollNo);
			session.setAttribute("PERSONAL_DETAILS",displayPersonalDetails);
			session.setAttribute("PERSONAL_BOOK_DETAILS",displayPersonalEnrolledBookList);
		    response.sendRedirect("displaypersonaldetails.jsp");
		}catch(Exception e) {
		    response.sendRedirect("studentoperation.jsp");
		}
	}
}
