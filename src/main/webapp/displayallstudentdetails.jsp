<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.suriya.model.Student"%>
<%
if((String)session.getAttribute("LOGGED_IN_STAFF")==null){
	response.sendRedirect("stafflogin.jsp");
}
String tempLoginStaff=(String)session.getAttribute("LOGGED_IN_STAFF");
 // List<Student> allStudentList=(List<Student>)session.getAttribute("STUDENT_LIST");
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
    <label> Enter Student ID:</label>
	<input type="number" id="studentId" oninput="getStudentDetails()" placeholder="Enter student Id" > <br>
	<label>Status Type:</label>
			<select name="status" id="status" onchange="getStudentDetails()">
				<option value="" selected>Empty</option>
				<option value="SUCCESS" >SUCCESS</option>
				<option value="PENDING">PENDING</option>
			    <option value="NOTPAID">NOTPAID</option>		
			</select>
	
<table class="table table-bordered" id="table">
	<thead>
	   <tr>
	    <th>RollNo</th>
	    <th>MobileNo</th>
	    <th>Fee</th>
	    <th>Payment Status</th> 
	   </tr>
	 </thead>
	 <tbody id="studentDetail-tbl">
     
	</tbody>
</table>	
</main>

<script>
		getStudentDetails();
function getStudentDetails(){
	let status=document.getElementById("status").value;
	let studentId=document.getElementById("studentId").value;
	
	console.log("Fetching all details");
	let url="DisplayStudentDetailsServlet";
	fetch(url).then(res=>res.json()).then(res=>{
		console.log(res);
		
		let studentDetails=res;
		console.log("Got response from servlet");
		
		if(status!=null){
		   studentDetails=filterStatus(studentDetails,status);	
		}
		
		if(studentId!=null){
			 studentDetails=filterId(studentDetails,studentId);
		}
		
		 let content="";
		for (let studentDetail of studentDetails){
			
 				content +="<tr><td>"+ studentDetail.rollNo+ "</td><td>"+ studentDetail.mobNo+"</td><td>"+studentDetail.fee+"</td><td>"+studentDetail.paymentDetails+"</td></tr>";					
		}
		console.log(content);
		document.querySelector("#studentDetail-tbl").innerHTML=content; 
		
		})
}


function filterStatus(res,status) {
	filteredDetails=res.filter(res=>res.paymentDetails.includes(status));
	return filteredDetails;
	}
	
function filterId(res,studentId){
	filteredDetails=res.filter(res=>res.rollNo.toString().includes(studentId));
	return filteredDetails;
}

</script>

</body>
</html>