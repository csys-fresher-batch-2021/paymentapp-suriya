<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if((String)session.getAttribute("LOGGED_IN_STUDENT")==null){
	response.sendRedirect("studentlogin.jsp");
}
String tempLoginStudent=(String)session.getAttribute("LOGGED_IN_STUDENT");
session.setAttribute("TEMP_LOGIN_STUDENT", tempLoginStudent);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="studentheader.jsp"></jsp:include>
	<main class="container-fluid">
<div align="center">
<form action="StudentBusRequestServlet" method="get">
<h4>Apply Bus Facility</h4>
<table>
    <tr><td><label>Bus Route:</label></td>
			<td><select name="bus" id="bus" required>
				<option value="none" selected>select...</option>
				<option value="tirunelveli">Tirunelveli</option>
				<option value="madurai">Madurai</option>	
				<option value="tuticorin">Tuticorin</option>		
			</select></td></tr>
</table>
<button type="submit">Submit</button><br>
<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
</form>
</div>
	
	
</main>	

</body>
</html>