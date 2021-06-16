<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.suriya.model.Student"%>
<%@page import="in.suriya.model.EnrolledBook"%>
<%@page import="in.suriya.model.ScholarshipRequest"%>

<%
if((String)session.getAttribute("LOGGED_IN_STAFF")==null){
	response.sendRedirect("stafflogin.jsp");
}
String tempLoginStaff=(String)session.getAttribute("LOGGED_IN_STAFF");
session.setAttribute("TEMP_LOGIN_STAFF", tempLoginStaff);
  List<ScholarshipRequest> scholarshipRequestsList=(List<ScholarshipRequest>)session.getAttribute("SCHOLARSHIP_REQUEST_LIST");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="requestheader.jsp"></jsp:include>
	<main class="container-fluid">
<h2>Applied Students List for Scholarship</h2>
	
<table class="table table-bordered">
	<thead>
	   <tr>
	    <th>Name</th>
	    <th>RollNo</th>
	    <th>MobNo</th>
	    <th>Family Income</th>
	    <th>Request</th>
	   </tr>
	 </thead>
	 <tbody>
     <%  for(ScholarshipRequest scholarshipRequestList:scholarshipRequestsList){%>
	   <tr>
	     <td><%= scholarshipRequestList.getName()%></td>
	     <td><%= scholarshipRequestList.getRollNo()  %></td>
	     <td><%= scholarshipRequestList.getMobNo() %></td>
	     <td><%= scholarshipRequestList.getIncome() %></td>
	     <td><a href="ScholarshipRequestStatusServlet?val=Approved&rollNo=<%=scholarshipRequestList.getRollNo() %>" class="btn btn-info">Approve</a>
	         <a href="ScholarshipRequestStatusServlet?val=Rejected&rollNo=<%=scholarshipRequestList.getRollNo() %>" class="btn btn-danger">Reject</a>
	       </td>
	     <%} %>
	   </tr>  
	 
	</tbody>
</table>
	
</main>

</body>
</html>