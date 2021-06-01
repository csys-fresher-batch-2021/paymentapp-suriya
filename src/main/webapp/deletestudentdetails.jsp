<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
if((String)session.getAttribute("LOGGED_IN_STAFF")==null){
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
<div align="center">
<form action="DeleteStudentDetailsServlet" method="get">
<h4>Delete Student Details</h4>
<table>
  <tr><td><label for="rollNo">Roll Number:</label></td>
        <td> <input type="number" name="rollNo"  placeholder="Enter 7-digit Roll number" required autofocus></td></tr>

</table>
<button type="submit">Submit</button>


</form>
</div>
	
</main>

</body>
</html>