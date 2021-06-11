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
import in.suriya.model.Fee;
import in.suriya.model.Student;
import in.suriya.service.librarian.DisplayBookDetailsService;
import in.suriya.service.student.DisplayStudentDetailsService;

/**
 * Servlet implementation class DisplayPersonalFeeDetailsServlet
 */
@WebServlet("/DisplayPersonalFeeDetailsServlet")
public class DisplayPersonalFeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			HttpSession session=request.getSession();
			String rollNo=(String)session.getAttribute("LOGGED_IN_STUDENT");
			
			DisplayStudentDetailsService dispFee=new DisplayStudentDetailsService();
			List<Fee> displayPersonalFeeList=dispFee. displayPersonalFeeDetails(rollNo);
			
			session.setAttribute("PERSONAL_FEE_DETAILS",displayPersonalFeeList);
		    response.sendRedirect("personalfeedetails.jsp");
		
		}catch(Exception e) {
		    response.sendRedirect("studentoperation.jsp");

		}
	
	
	}

	

}
