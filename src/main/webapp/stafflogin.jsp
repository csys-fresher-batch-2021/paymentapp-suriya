<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%session.setAttribute("TEMP_LOGIN_STAFF",null);
if((String)session.getAttribute("LOGGED_IN_STAFF")!=null){
	response.sendRedirect("staffoperation.jsp");
}%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>STAFFLOGIN</title>
</head>
<body>
<jsp:include page="staffheader.jsp"></jsp:include>
	<main class="container-fluid">
		
<div align="center">
<form action="StaffLoginServlet" method="get">
<h4>Signin</h4>
<table>
   <tr><td><label for="mobileNo">Mobile Number:</label></td>
       <td><input type="number" name="mobileNo" pattern="[6-9][0-9]{9}"  placeholder="Enter 10-digit mobile number" required autofocus></td></tr>
   
   <tr><td><label for="password">Password:</label></td>
        <td> <input type="password" name="password" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$"  placeholder="pass[0-9][a-z][A-Z][@#$%]" required></td></tr>


</table>
<button type="submit">Submit</button>
<button type="reset">Reset</button>

</form>
</div>
</main>

</body>
</html>