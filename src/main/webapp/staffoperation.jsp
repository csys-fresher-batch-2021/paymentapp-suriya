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
<jsp:include page="staffheader.jsp"></jsp:include>
	<main class="container-fluid">
<h2>Welcome !!!!!</h2>
<a href="staffchangepassword.jsp">change password</a>
<br/>
<a href="addstudentdetails.jsp">Register student</a>
<br/>
<a href="deletestudentdetails.jsp">Remove student</a>
<br/>
<a href="displayallstudentdetails.jsp">Student Details</a>
<br/>
<a href="feestructure.jsp">Fee structure</a>
<br/>
</main>
</body>
</html>