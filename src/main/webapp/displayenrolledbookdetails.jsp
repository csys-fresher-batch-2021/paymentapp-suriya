<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.suriya.model.Student"%>
<%
if((String)session.getAttribute("LOGGED_IN_LIBRARIAN")==null){
	response.sendRedirect("librarianlogin.jsp");
}
String tempLoginLibrarian=(String)session.getAttribute("LOGGED_IN_LIBRARIAN");
session.setAttribute("TEMP_LOGIN_LIBRARIAN", tempLoginLibrarian);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="librarianheader.jsp"></jsp:include>
	<main class="container-fluid">
	<h2>Enrolled Book Details</h2>
    <label> Enter book name:</label>
	<input type="text" id="bookName" oninput="getEnrolledBookDetails()" placeholder="Enter book name " > 
	
	
<table class="table table-bordered" id="table">
	<thead>
	   <tr>
	    <th>BookId</th>
	    <th>BookName</th>
	    <th>RollNo</th>
	    <th>MobNo</th>
	    <th>EnrolledDate</th>
	   </tr>
	 </thead>
	 <tbody id="enrolledBookDetail-tbl">
     
	</tbody>
</table>	
</main>

<script>
		getEnrolledBookDetails();
function getEnrolledBookDetails(){
	let bookName=document.getElementById("bookName").value;
	console.log("Fetching all details");
	let url="DisplayEnrolledBookDetailsServlet";
	fetch(url).then(res=>res.json()).then(res=>{
		console.log(res);
		
		let enrolledBookDetails=res;
		console.log("Got response from servlet");
		
		if(bookName!=null){
			enrolledBookDetails=filterBookName(enrolledBookDetails,bookName);	
		}
		
		
		 let content="";
		for (let enrolledBookDetail of enrolledBookDetails){
			
 				content +="<tr><td>"+ enrolledBookDetail.bookId+ "</td><td>"+ enrolledBookDetail.bookName+"</td><td>"+enrolledBookDetail.rollNo+"</td><td>"+enrolledBookDetail.mobNo+"</td><td>"+enrolledBookDetail.enrolledDate+"</td></tr>";					
		}
		console.log(content);
		document.querySelector("#enrolledBookDetail-tbl").innerHTML=content; 
		
		})
}


function filterBookName(res,bookName) {
	filteredDetails=res.filter(res=>res.bookName.includes(bookName));
	return filteredDetails;
}
	

</script>

</body>
</html>