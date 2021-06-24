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
import in.suriya.model.SchemeRequest;
import in.suriya.service.student.DisplayRequestDetailsService;

/**
 * Servlet implementation class DisplaySchemeRequestServlet
 */
@WebServlet("/DisplaySchemeRequestServlet")
public class DisplaySchemeRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DisplayRequestDetailsService dispSchemeRequestList= new DisplayRequestDetailsService();
			List<SchemeRequest> displaySchemeRequestList=dispSchemeRequestList.displaySchemeRequestList();
			HttpSession session=request.getSession();
			session.setAttribute("SCHEME_REQUEST_LIST",displaySchemeRequestList);
		    response.sendRedirect("schemerequest.jsp");
		}catch(Exception e) {
		    response.sendRedirect("requestpage.jsp");
		}
	}
}
