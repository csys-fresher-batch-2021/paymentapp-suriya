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
<div align="center">
<form action="StudentScholarshipRequestServlet" method="get">
<h4>Apply Bus & govt.Schemes</h4>
<table>
     <tr><td><label>Do you want to apply for scholarship:</label></td>
             <td><input type="radio" id="yes" name="scholarship" value="yes"onclick="ShowHideText()" >
             <label for="yes">Yes</label>
             <input type="radio" id="no" name="scholarship" value="no" onclick="ShowHideText()"required>
             <label for="no">No</label><br>
             </td></tr>
             
             
       <tr><td><div id="dvtext" style="display: none">
            <label>Family Annual Income:</label>
            <input type="number" id="salary" name="salary"placeholder="salary>10000">
            </div>
        </td></tr>
            
              
        <tr><td><label>Bus Route:</label></td>
			<td><select name="bus" id="bus">
				<option value="none" selected>select...</option>
				<option value="tirunelveli">Tirunelveli</option>
				<option value="madurai">Madurai</option>	
				<option value="tuticorin">Tuticorin</option>		
			</select></td></tr>
    <tr><td><label>First Graduate:</label></td>
			<td><select name="firstGraduate" id="firstGraduate" required>
			    <option value="" selected >select...</option>
				<option value="0" >No</option>
				<option value="1">Yes</option>		
			</select></td></tr>
  <tr><td><label>GOVT.Schemes:</label></td>
			<td><select name="schemes" id="schemes">
			    <option value="none" selected>select...</option>
				<option value="Prime Minister Special Scholarship Scheme (PMSSS), Assam" >Prime Minister Special Scholarship Scheme (PMSSS), Assam</option>
				<option value="Prime Minister Special Scholarship Scheme (PMSSS), J&K">Prime Minister Special Scholarship Scheme (PMSSS), J&K</option>		
			</select></td></tr>
	
	
 
      
</table>



<button type="submit">Submit</button><br>
<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
</form>
</div>
</main>	
<script>
function ShowHideText() {
   var chkYes = document.getElementById("yes");
    var dvtext = document.getElementById("dvtext");
    dvtext.style.display = chkYes.checked ? "block" : "none";
}

</script>
</body>
</html>