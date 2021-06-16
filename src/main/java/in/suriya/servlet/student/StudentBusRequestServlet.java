package in.suriya.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.service.student.StudentScholarshipRequestService;
import in.suriya.util.Validation;

/**
 * Servlet implementation class StudentBusRequestServlet
 */
@WebServlet("/StudentBusRequestServlet")
public class StudentBusRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{   
			  String busRoute=request.getParameter("bus");
           
			  HttpSession session=request.getSession();
			  String rollNo=(String)session.getAttribute("LOGGED_IN_STUDENT");
			  
			  StudentScholarshipRequestService paymentCalc=new StudentScholarshipRequestService();
			  boolean paymentStatus = paymentCalc.studentBusRequest(busRoute,rollNo);

			 if (paymentStatus) {
				  String message = "Bus Request Submitted ";
				  response.sendRedirect("studentoperation.jsp?infoMessage=" + message);
				}
			 else {
				  response.sendRedirect("applybus.jsp?errorMessage=You already applied ");
			 }
			}catch(Exception e) {
				
				  String message =e.getMessage();
				  response.sendRedirect("applybus.jsp?errorMessage=" + message);

			}
	
	
	}

	

}
