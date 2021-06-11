<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if((String)session.getAttribute("LOGGED_IN_LIBRARIAN")==null){
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
<h2>Welcome  librarian <%=tempLoginLibrarian %>!!!!!</h2>
<a href="availablebook.jsp">available book </a>
<br/>
<a href="displayenrolledbookdetails.jsp"> Enrolled book </a>
<br/>
<%
			String infoMessage = request.getParameter("infoMessage");
			if (infoMessage!= null) {
				out.println("<font color='green'>" + infoMessage + "</font>");
			}
			%>


</main>
</body>
</html>