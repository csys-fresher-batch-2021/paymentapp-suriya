<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.suriya.model.Student"%>
<%@page import="in.suriya.model.EnrolledBook"%>
<%@page import="in.suriya.model.SchemeRequest"%>
<%
if((String)session.getAttribute("LOGGED_IN_STAFF")==null){
	response.sendRedirect("stafflogin.jsp");
}
String tempLoginStaff=(String)session.getAttribute("LOGGED_IN_STAFF");
session.setAttribute("TEMP_LOGIN_STAFF", tempLoginStaff);
List<SchemeRequest> schemeRequestsList=(List<SchemeRequest>)session.getAttribute("SCHEME_REQUEST_LIST");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="requestheader.jsp"></jsp:include>
	<main class="container-fluid">
	<h2>Applied Students List for Government Scheme</h2>
	<h4>*J&K-60% fee will be paid by government  </h4>
	<h4>*Assam-40% fee will be paid by government  </h4>
<table class="table table-bordered">
	<thead>
	   <tr>
	    <th>Name</th>
	    <th>RollNo</th>
	    <th>MobNo</th>
	    <th>Location</th>
	    <th>Scheme</th>
	    <th>Request</th>
	   </tr>
	 </thead>
	 <tbody>
     <%  for(SchemeRequest schemeRequestList:schemeRequestsList){%>
	   <tr>
	     <td><%= schemeRequestList.getName()%></td>
	     <td><%= schemeRequestList.getRollNo()  %></td>
	     <td><%= schemeRequestList.getMobNo() %></td>
	     <td><%= schemeRequestList.getLocation()%></td>
	     <td><%= schemeRequestList.getScheme() %></td>
	     <td><a href="SchemeRequestStatusServlet?val=Approved&rollNo=<%=schemeRequestList.getRollNo() %>" class="btn btn-info">Approve</a>
	         <a href="SchemeRequestStatusServlet?val=Rejected&rollNo=<%=schemeRequestList.getRollNo() %>" class="btn btn-danger">Reject</a>
	       </td>
	     <%} %>
	   </tr>  
	</tbody>
</table>
</main>
</body>
</html>