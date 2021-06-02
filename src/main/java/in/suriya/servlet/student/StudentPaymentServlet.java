package in.suriya.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.service.student.StudentPaymentService;
import in.suriya.util.Validation;

/**
 * Servlet implementation class StudentPaymentServlet
 */
@WebServlet("/StudentPaymentServlet")
public class StudentPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			  int fee=Validation.parseInt(request.getParameter("fee"),"Invalid Fee");

			  HttpSession session=request.getSession();
			  String rollNo=(String)session.getAttribute("LOGGED_IN_STUDENT");
			  
			  boolean paymentStatus = StudentPaymentService.payment(fee,rollNo);

			 if (paymentStatus) {
				  String message = "payment sucessfully";
				  response.sendRedirect("studentoperation.jsp?infoMessage=" + message);
				}
			}catch(Exception e) {
				
				  String message =e.getMessage();
				  response.sendRedirect("studentpayment.jsp?infoMessage=" + message);

			}
			

	
	
	}

	
}
