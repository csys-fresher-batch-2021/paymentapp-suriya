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
<form action="AddStudentDetailsServlet" method="get">
<h4>Add Student Details</h4>
<table>
  <tr><td><label for="rollNo">Roll Number:</label></td>
        <td> <input type="number" name="rollNo"  placeholder="Enter 7-digit roll number" required autofocus></td></tr>
   
   <tr><td><label for="mobileNo">Mobile Number:</label></td>
        <td> <input type="number" name="mobileNo" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$"  placeholder="Enter 10-digit mobile number" required></td></tr>

 <tr><td><label for="fee">Fee:</label></td>
        <td> <input type="number" name="fee"  placeholder="Enter fee<100000 " required></td></tr>


</table>
<button type="submit">Submit</button>
<button type="reset">Reset</button><br/>
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