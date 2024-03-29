package in.suriya.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.suriya.model.BusRequest;
import in.suriya.model.Student;
import in.suriya.service.student.DisplayRequestDetailsService;
import in.suriya.service.student.DisplayStudentDetailsService;

/**
 * Servlet implementation class DisplayFeeServlet
 */
@WebServlet("/DisplayBusRequestServlet")
public class DisplayBusRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DisplayRequestDetailsService dispBusRequestList= new DisplayRequestDetailsService();
			List<BusRequest> displayBusRequestList=dispBusRequestList.displayBusRequestList();
     		HttpSession session=request.getSession();
			session.setAttribute("BUS_REQUEST_LIST",displayBusRequestList);
		    response.sendRedirect("busrequest.jsp");
		}catch(Exception e) {
		    response.sendRedirect("requestpage.jsp");
		}
	}
}
