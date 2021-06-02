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
<div align="center">
<form action="StudentPaymentServlet" method="get">
<h4>Payment details</h4>
<table>
   <tr><td><label for="fee">Fee:</label></td>
       <td><input type="number" name="fee"placeholder="Enter fee to pay" required autofocus></td></tr>
</table>

<button type="submit">Submit</button>
</form>
</div>
	
	
</main>	

</body>
</html>