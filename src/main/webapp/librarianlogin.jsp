<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%session.setAttribute("TEMP_LOGIN_LIBRARIAN",null);
if((String)session.getAttribute("LOGGED_IN_LIBRARIAN")!=null){
	response.sendRedirect("librarianoperation.jsp");
}%>

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
<form action="LibrarianLoginServlet" method="get">
<h4>Librarian Signin</h4>
<table>
   <tr><td><label for="userName">UserName:</label></td>
       <td><input type="text" name="userName"placeholder="Enter username" required autofocus></td></tr>
   
   <tr><td><label for="password">Password:</label></td>
        <td> <input type="password" name="password" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$" placeholder="pass[0-9][a-z][A-Z][@#$%]" required ></td></tr>

</table>

<button type="submit">Submit</button>
<button type="reset">Reset</button><br>
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