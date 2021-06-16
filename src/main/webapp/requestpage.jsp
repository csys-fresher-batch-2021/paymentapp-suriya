<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if((String)session.getAttribute("LOGGED_IN_STAFF")==null){
	response.sendRedirect("stafflogin.jsp");
}
String tempLoginStaff=(String)session.getAttribute("LOGGED_IN_STAFF");
session.setAttribute("TEMP_LOGIN_STAFF", tempLoginStaff);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="requestheader.jsp"></jsp:include>
	<main class="container-fluid">
<h2>click requests !!!!!</h2>
<h4>*Scheme Request Approved based on Location</h4>
<h4>*Scholarship Request Approved based on family income</h4>
<h4>Finally bus request has to be accepted based on bus route </h4>
<%
			String infoMessage = request.getParameter("infoMessage");
			if (infoMessage!= null) {
				out.println("<font color='green'>" + infoMessage + "</font>");
			}
			%>
			<br>
			
			
<br/>
</main>
</body>
</html>