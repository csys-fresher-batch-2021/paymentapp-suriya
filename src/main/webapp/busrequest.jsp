<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.suriya.model.Student"%>
<%@page import="in.suriya.model.EnrolledBook"%>
<%@page import="in.suriya.model.BusRequest"%>

<%
if((String)session.getAttribute("LOGGED_IN_STAFF")==null){
	response.sendRedirect("stafflogin.jsp");
}
String tempLoginStaff=(String)session.getAttribute("LOGGED_IN_STAFF");
session.setAttribute("TEMP_LOGIN_STAFF", tempLoginStaff);
  List<BusRequest> busRequestsList=(List<BusRequest>)session.getAttribute("BUS_REQUEST_LIST");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="requestheader.jsp"></jsp:include>
	<main class="container-fluid">
	<h2>Applied Students List for Bus</h2>
	
<table class="table table-bordered">
	<thead>
	   <tr>
	    <th>Name</th>
	    <th>RollNo</th>
	    <th>MobNo</th>
	    <th>BusRoute</th>
	    <th>Request</th>
	   </tr>
	 </thead>
	 <tbody>
     <%  for(BusRequest busRequestList:busRequestsList){%>
	   <tr>
	     <td><%= busRequestList.getName()%></td>
	     <td><%= busRequestList.getRollNo()  %></td>
	     <td><%= busRequestList.getMobNo() %></td>
	     <td><%= busRequestList.getBusRoute() %></td>
	     <td><a href="BusRequestStatusServlet?val=Approved&rollNo=<%=busRequestList.getRollNo() %>" class="btn btn-info">Approve</a>
	         <a href="BusRequestStatusServlet?val=Rejected&rollNo=<%=busRequestList.getRollNo() %>" class="btn btn-danger">Reject</a>
	       </td>
	     <%} %>
	   </tr>  
	 
	</tbody>
</table>
	
</main>

</body>
</html>