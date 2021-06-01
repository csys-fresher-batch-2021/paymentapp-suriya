<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%session.setAttribute("TEMP_LOGIN_STUDENT",null); %>

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
<form action="StudentLoginServlet" method="get">
<h4>Signin</h4>
<table>
   <tr><td><label for="rollNo">Roll Number:</label></td>
       <td><input type="number" name="rollNo"placeholder="Enter Roll number" required autofocus></td></tr>
   
   <tr><td><label for="mobileNumber">Mobile Number:</label></td>
        <td> <input type="number" name="mobileNumber" pattern="[6-9][0-9]{9}"   placeholder="Enter Mobile Number" required ></td></tr>

</table>

<button type="submit">Submit</button>
<button type="reset">Reset</button>
</form>
</div>
	
	
</main>	
</body>
</html>