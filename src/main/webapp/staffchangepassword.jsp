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
<form action="StaffChangePasswordServlet" method="get">
<h4>Change Password</h4>
<table>
  <tr><td><label for="currentPassword">Current Password:</label></td>
        <td> <input type="password" name="currentPassword" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$"  placeholder="Enter current password" required></td></tr>
   
   <tr><td><label for="newpassword">New Password:</label></td>
        <td> <input type="password" name="newPassword" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$"  placeholder="Enter new password" required></td></tr>


</table>
<button type="submit">Submit</button>
<button type="reset">Reset</button>

</form>
</div>
	
</main>
</body>
</html>