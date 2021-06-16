<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if((String)session.getAttribute("LOGGED_IN_STUDENT")==null){
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
<h2>Welcome !!!!!</h2>
<%
			String infoMessage = request.getParameter("infoMessage");
			if (infoMessage!= null) {
				out.println("<font color='green'>" + infoMessage + "</font>");
			}
			%><br>
<a href="displayscholarshipdetails.jsp">Scholarship And Bus Details</a>

</main>
</body>
</html>