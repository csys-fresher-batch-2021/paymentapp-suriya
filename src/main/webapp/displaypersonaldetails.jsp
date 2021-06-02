<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.suriya.model.Student"%>
<%
if((String)session.getAttribute("LOGGED_IN_STUDENT")==null){
	response.sendRedirect("studentlogin.jsp");
}
String tempLoginStudent=(String)session.getAttribute("LOGGED_IN_STUDENT");
  session.setAttribute("TEMP_LOGIN_STUDENT", tempLoginStudent);
  List<Student> personalDetailsList=(List<Student>)session.getAttribute("PERSONAL_DETAILS");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="studentheader.jsp"></jsp:include>
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
     <%  for(Student personalList:personalDetailsList){%>
	   <tr>
	     <td><%=personalList.getRollNo()%></td>
	     <td><%=personalList. getMobNo() %></td>
	     <td><%=personalList.getFee() %></td>
	     <td><%=personalList.getPaymentDetails() %></td>
	     
	   </tr>  
	  <% } %>
	</tbody>
</table>	
</main>

</body>
</html>