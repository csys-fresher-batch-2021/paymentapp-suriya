package in.suriya.servlet.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.suriya.service.staff.AddAndDeleteStudentDetailsService;
import in.suriya.service.student.StudentPaymentService;
import in.suriya.util.Validation;

/**
 * Servlet implementation class feeStructureServlet
 */
@WebServlet("/FeeStructureServlet")
public class FeeStructureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 long rollNo = Validation.parseLong(request.getParameter("rollNo"),"Invalid Roll number");
			 int feeStructure=Validation.parseInt(request.getParameter("feeStructure"),"Invalid Fee Structure");
			 if(feeStructure<1 || feeStructure>4) throw new Exception("Invalid Fee Structure");
             StudentPaymentService feeStruct=new StudentPaymentService();
			 boolean valid=feeStruct.feeStructureUpdate(rollNo,feeStructure);
		     if(valid){
				  String message = "Fee Structure Updated Sucessfully";
				  response.sendRedirect("staffoperation.jsp?infoMessage=" + message);
			  }else{
				  String message = "Student Details does not Exist";
				  response.sendRedirect("feestructure.jsp?errorMessage=" + message);
				  }
		}catch(Exception e) {
			String message = e.getMessage();
			response.sendRedirect("feestructure.jsp?errorMessage=" + message);
		}
	}
}
