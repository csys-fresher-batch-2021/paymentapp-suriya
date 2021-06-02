<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.suriya.model.Student"%>
<%
if((String)session.getAttribute("LOGGED_IN_STAFF")==null){
	response.sendRedirect("stafflogin.jsp");
}
String tempLoginStaff=(String)session.getAttribute("LOGGED_IN_STAFF");
  List<Student> allStudentList=(List<Student>)session.getAttribute("STUDENT_LIST");
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
<table class="table table-bordered">
	<thead>
	   <tr>
	    <th>RollNo</th>
	    <th>MobileNo</th>
	    <th>Fee</th>
	    <th>Payment Status</th> 
	   </tr>
	 </thead>
	 <tbody>
     <%  for(Student studList:allStudentList){%>
	   <tr>
	     <td><%=studList.getRollNo()%></td>
	     <td><%=studList. getMobNo() %></td>
	     <td><%=studList.getFee() %></td>
	     <td><%=studList.getPaymentDetails() %></td>
	     
	   </tr>  
	  <% } %>
	</tbody>
</table>	
</main>
</body>
</html>