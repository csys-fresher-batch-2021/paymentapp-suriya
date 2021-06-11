package in.suriya.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.model.BusRequest;
import in.suriya.model.ScholarshipRequest;
import in.suriya.service.student.DisplayRequestDetailsService;

/**
 * Servlet implementation class DisplayScholarshipRequestServlet
 */
@WebServlet("/DisplayScholarshipRequestServlet")
public class DisplayScholarshipRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			DisplayRequestDetailsService dispscholarshipRequestList= new DisplayRequestDetailsService();
			List<ScholarshipRequest> displayScholarshipRequestList=dispscholarshipRequestList.displayScholarshipRequestList();

			HttpSession session=request.getSession();
			session.setAttribute("SCHOLARSHIP_REQUEST_LIST",displayScholarshipRequestList);
		    response.sendRedirect("scholarshiprequest.jsp");
		

		}catch(Exception e) {
		    response.sendRedirect("requestpage.jsp");

		}
	
	
	
	}

	

}
