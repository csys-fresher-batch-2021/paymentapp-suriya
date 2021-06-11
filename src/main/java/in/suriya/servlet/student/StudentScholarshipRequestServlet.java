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
 * Servlet implementation class StudentPaymentCalculationServlet
 */
@WebServlet("/StudentScholarshipRequestServlet")
public class StudentScholarshipRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{   
			  int salary=1;
			  String scholarshipStatus=request.getParameter("scholarship");
			  if(scholarshipStatus.equals("yes")) {
				  salary=Validation.parseInt(request.getParameter("salary"),"Enter Annual Income");
				  Validation.salaryValidater(salary);
			  }
			  
              String busRoute=request.getParameter("bus");
              int firstGraduate=Integer.parseInt(request.getParameter("firstGraduate"));
              String govtSchemes=request.getParameter("schemes");

              
			  HttpSession session=request.getSession();
			  String rollNo=(String)session.getAttribute("LOGGED_IN_STUDENT");
			  
			  StudentScholarshipRequestService paymentCalc=new StudentScholarshipRequestService();
			  boolean paymentStatus = paymentCalc.studentScholarshipRequest(scholarshipStatus,salary,busRoute,firstGraduate,govtSchemes,rollNo);

			 if (paymentStatus) {
				  String message = "Scholarship Schemes and Bus Request Submitted ";
				  response.sendRedirect("studentoperation.jsp?infoMessage=" + message);
				}
			 else {
				  response.sendRedirect("filldetails.jsp?errorMessage=You already applied ");
			 }
			}catch(Exception e) {
				
				  String message =e.getMessage();
				  response.sendRedirect("filldetails.jsp?errorMessage=" + message);

			}
	
	
	
	}

	

}
