package in.suriya.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.suriya.service.student.DisplayRequestDetailsService;

/**
 * Servlet implementation class SchemeRequestStatusServlet
 */
@WebServlet("/SchemeRequestStatusServlet")
public class SchemeRequestStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String schemeRequest=request.getParameter("val");
			String rollNo=request.getParameter("rollNo");
			DisplayRequestDetailsService schemeRequestList= new DisplayRequestDetailsService();
			boolean update=schemeRequestList.schemeRequestUpdate(rollNo,schemeRequest);
			response.sendRedirect("DisplaySchemeRequestServlet");
		}catch(Exception e) {
		    response.sendRedirect("schemerequest.jsp");
		    }
	}
}
