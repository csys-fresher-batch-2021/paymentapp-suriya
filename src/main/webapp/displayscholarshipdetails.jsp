<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if((String)session.getAttribute("LOGGED_IN_STUDENT")==null){
	response.sendRedirect("studentlogin.jsp");
	}
String tempLoginStudent=(String)session.getAttribute("LOGGED_IN_STUDENT");
session.setAttribute("TEMP_LOGIN_STUDENT", tempLoginStudent);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="studentheader.jsp"></jsp:include>
	<main class="container-fluid">
<h2>Scholarship Details </h2>
<table class="table table-bordered" >
<thead>
   <tr>
     <th>Type</th>
     <th>Information</th>
     <th>Fee Detection Details</th>
   </tr>
</thead>
<tbody>
    <tr>
      <td>Scholarship:</td>
       <td> Your Family Income<500000.Scholarship available for only 100 students.It is allocated based on family's income.</td> 
       <td>10% fee will be reduced</td>
    </tr>
    <tr>
      <td>Govt_Scheme:</td>
       <td>Depends on the location</td>
       <td>40% fee paid by government will be reduced for Assam Scheme--or--60% fee paid by government will be reduced for J&K Scheme</td>
    </tr>

</tbody>
</table>
<a href="filldetails.jsp">Apply</a><br>
<h2>Bus Facility Details </h2>
<table class="table table-bordered">
<thead>
   <tr>
     <td>Bus Route</td>
     <td>Bus Stops</td>
     <td>Bus Fee</td>
   </tr>
</thead>
<tbody>
  <tr>
    <td>Tirunelveli</td>
    <td>Tirunelveli old bus stand,Ragavan nagar,n.s.t nagar,Gopal nagar,venkatesh nagar,krishnan kovil </td>
    <td>Rs.8000</td>
  </tr>
  <tr>
    <td>Madurai</td>
    <td>Madurai bus stand,Srini nagar,Perumal kovil,Ganapathy colony,Ramesh nagar,Indra nagar</td>
    <td>Rs.10000</td>
  </tr>
  <tr>
    <td>Tuticorin</td>
    <td>Tuticorin bus stand,Shetty nagar,Rahul krishnan nagar,M.G.R nagar,Kumaran colony ,k.G nagar</td>
    <td>Rs.12000</td>
  </tr>

</tbody>

</table>
<a href="applybus.jsp">Apply</a>
</main>
</body>
</html>