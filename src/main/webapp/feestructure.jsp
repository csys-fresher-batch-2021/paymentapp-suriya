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
<form action="FeeStructureServlet" method="get">
<h4>Fee Structure</h4>
<table>
  <tr><td><label for="rollNo">Roll Number:</label></td>
        <td> <input type="number" name="rollNo"  placeholder="Enter 7-digit Roll number" required autofocus></td></tr>
  <tr><td><label>Fee Structre:</label></td>
	    <td><select name="feeStructure" id="feeStructure">
			<option value="1" >oneWay payment</option>
			<option value="2">twoWay payment</option>
			<option value="3" >threeWay payment</option>
			<option value="4">fourWay payment</option>			
		</select></td></tr>
</table>
<button type="submit">Submit</button><br>
<%String errorMessage = request.getParameter("errorMessage");
if (errorMessage != null) {
	out.println("<font color='red'>" + errorMessage + "</font>");
}%>
</form>
</div>
</main>
</body>
</html>