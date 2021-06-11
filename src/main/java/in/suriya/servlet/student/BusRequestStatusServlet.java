package in.suriya.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.suriya.service.student.DisplayRequestDetailsService;

/**
 * Servlet implementation class BusRequestStatusServlet
 */
@WebServlet("/BusRequestStatusServlet")
public class BusRequestStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String busRequest=request.getParameter("val");
			String rollNo=request.getParameter("rollNo");
			
			DisplayRequestDetailsService busRequestList= new DisplayRequestDetailsService();
			boolean update=busRequestList.busRequestUpdate(rollNo,busRequest);

			
		    response.sendRedirect("DisplayBusRequestServlet");
		

		}catch(Exception e) {
		    response.sendRedirect("busrequest.jsp");

		}
	}
	

}
