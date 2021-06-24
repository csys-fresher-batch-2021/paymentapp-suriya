<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.suriya.model.Student"%>
<%@page import="in.suriya.model.Fee"%>
<%if((String)session.getAttribute("LOGGED_IN_STUDENT")==null){
	response.sendRedirect("studentlogin.jsp");
}
String tempLoginStudent=(String)session.getAttribute("LOGGED_IN_STUDENT");
  session.setAttribute("TEMP_LOGIN_STUDENT", tempLoginStudent);
  List<Fee> personalFeeRequestsList=(List<Fee>)session.getAttribute("PERSONAL_FEE_DETAILS");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="studentheader.jsp"></jsp:include>
	<main class="container-fluid">
<h2>Scholarship Request Status Details</h2>
<table class="table table-bordered">
	<thead>
	   <tr>
	    <th>RollNo</th>
	    <th>FirstGraduate</th>
	    <th>Scholarship</th>
	    <th>Govt_Scheme</th>
	    <th>Bus </th>
	   </tr>
	 </thead>
	 <tbody>
     <%  for(Fee personalFeeRequestList:personalFeeRequestsList){%>
	   <tr>
	     <td><%=personalFeeRequestList.getRollNo() %></td>
	     <td><%=personalFeeRequestList.getFirstGraduateRequest()%></td>
	     <td><%=personalFeeRequestList.getScholarshipRequest()%></td>
	     <td><%=personalFeeRequestList.getGovtSchemesRequest()%></td>
	     <td><%=personalFeeRequestList.getBusRequest()%></td>
	   </tr>  
	  <% } %>
	</tbody>
</table>		
</main>
</body>
</html>