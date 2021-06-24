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
	<h2>Available Book Details</h2>
	  <label> Enter book name:</label>
	<input type="text" id="bookName" oninput="getBookDetails()" placeholder="Enter book name " > <br>	
<table class="table table-bordered" id="table">
	<thead>
	   <tr>
	    <th>BookId</th>
	    <th>BookName</th>
	    <th>Quantity</th>
	   </tr>
	 </thead>
	 <tbody id="bookDetail-tbl">
	</tbody>
</table>	
</main>
<script>
		getBookDetails();
function getBookDetails(){
	let bookName=document.getElementById("bookName").value;
	console.log(bookName);
	console.log("Fetching all details");
	let url="DisplayBookDetailsServlet";
	fetch(url).then(res=>res.json()).then(res=>{
		console.log(res);
		let bookDetails=res;
		console.log("Got response from servlet");
		if(bookName!=null){
		   bookDetails=filterBookName(bookDetails,bookName);	
		}
		 let content="";
		for (let bookDetail of bookDetails){	
 				content +="<tr><td>"+ bookDetail.bookId+ "</td><td>"+ bookDetail.bookName+"</td><td>"+bookDetail.quantity+"</td></tr>";					
		}
		console.log(content);
		document.querySelector("#bookDetail-tbl").innerHTML=content; 
		})
}
function filterBookName(res,bookName) {
	filteredDetails=res.filter(res=>res.bookName.includes(bookName));
	return filteredDetails;
}
</script>
</body>
</html>