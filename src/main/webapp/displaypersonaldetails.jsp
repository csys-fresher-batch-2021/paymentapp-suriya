<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.suriya.model.Student"%>
<%@page import="in.suriya.model.EnrolledBook"%>
<%
if((String)session.getAttribute("LOGGED_IN_STUDENT")==null){
	response.sendRedirect("studentlogin.jsp");
}
String tempLoginStudent=(String)session.getAttribute("LOGGED_IN_STUDENT");
  session.setAttribute("TEMP_LOGIN_STUDENT", tempLoginStudent);
  List<Student> personalDetailsList=(List<Student>)session.getAttribute("PERSONAL_DETAILS");
  List<EnrolledBook> personalBookDetailsList=(List<EnrolledBook>)session.getAttribute("PERSONAL_BOOK_DETAILS");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="studentheader.jsp"></jsp:include>
	<main class="container-fluid">
<h2>Fee Details</h2>
	
<table class="table table-bordered">
	<thead>
	   <tr>
	    <th>RollNo</th>
	    <th>MobileNo</th>
	    <th>FeeStructureWay</th>
	    <th>Fee</th>
	    <th>Payment Status</th> 
	    <th>Scholarship Request Status</th>
	    <th>Pay</th>
	   </tr>
	 </thead>
	 <tbody>
     <%  for(Student personalList:personalDetailsList){%>
	   <tr>
	     <td><%=personalList.getRollNo()%></td>
	     <td><%=personalList. getMobNo() %></td>
	     <%if(personalList.getFee()!=0){ %>
	       <td><%=personalList.getFeeStructure() %></td>
	       <td><%=personalList.getFee() %></td>
	     <%}else{ %>
	       <td>None</td>
	       <td>Paid</td>
	     <%} %>
	     <td><%=personalList.getPaymentDetails() %></td>
	     <td><a href="DisplayPersonalFeeDetailsServlet" class="btn btn-info">view details</a></td>
	     <%if(personalList.getFee()!=0){ %>
	       <td><a href="studentpayment.jsp" class="btn btn-info">Pay</a></td>
	     <%} %>
	   </tr>  
	  <% } %>
	</tbody>
</table>
<h2>Books Taken</h2>

<table class="table table-bordered">
	<thead>
	   <tr>
	    <th>BookId</th>
	    <th>BookName</th>
	    <th>EnrolledDate</th>
	   </tr>
	 </thead>
	 <tbody>
     <%  for(EnrolledBook personalBookList:personalBookDetailsList){%>
	   <tr>
	     <td><%=personalBookList.getBookId()%></td>
	     <td><%=personalBookList.getBookName()%></td>
	     <td><%=personalBookList.getEnrolledDate() %></td>
	    
	   </tr>  
	  <% } %>
	</tbody>
</table>		
</main>

</body>
</html>