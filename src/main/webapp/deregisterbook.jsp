<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
if((String)session.getAttribute("LOGGED_IN_LIBRARIAN")==null){
	response.sendRedirect("librarianlogin.jsp");
}
String tempLoginLibrarian=(String)session.getAttribute("LOGGED_IN_LIBRARIAN");
session.setAttribute("TEMP_LOGIN_LIBRARIAN", tempLoginLibrarian);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="librarianheader.jsp"></jsp:include>
	<main class="container-fluid">
<div align="center">
<form action="DeleteRegisterServlet" method="get">
<h4>Enroll book for student</h4>
<table>
  <tr><td><label for="bookId">Book Id:</label></td>
        <td> <input type="number" name="bookId"   placeholder="Enter book Id" required autofocus></td></tr>
   
   <tr><td><label for="rollNo">Roll Number:</label></td>
       <td><input type="number" name="rollNo"placeholder="Enter 7-digit Roll number" required ></td></tr>
</table>
<button type="submit">Submit</button>
<button type="reset">Reset</button><br>
<%String errorMessage = request.getParameter("errorMessage");
if (errorMessage != null) {
	out.println("<font color='red'>" + errorMessage + "</font>");
}
%>
</form>
</div>
</main>
</body>
</html>