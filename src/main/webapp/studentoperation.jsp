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
<a href="studentpayment.jsp">Pay Fee</a>
<br/>
<a href="DisplayPersonalDetailsServlet"> Personal Details </a>


</main>
</body>
</html>