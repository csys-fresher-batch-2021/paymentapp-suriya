<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%
String loggedInStaff=(String)session.getAttribute("LOGGED_IN_STAFF");
String tempLoginStaff=(String)session.getAttribute("TEMP_LOGIN_STAFF");
%>
<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp">StudentScholarshipPayment</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
   <%  if(tempLoginStaff!=null){  %>
       <li class="nav-item active">
        <a class="nav-link"> <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="addstudentdetails.jsp">Enroll Student </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="deletestudentdetails.jsp">Delist Student </a>
      </li>
       <li class="nav-item active">
        <a class="nav-link" href="feestructure.jsp">Fee Structure </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="displayallstudentdetails.jsp">Student Details </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="requestpage.jsp">Requests </a>
      </li>
     <%} %>
      <%//if(tempLoginStaff!=null){ %>
       <li class="nav-item dropdown">
        <a class="nav-link " href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
        <div class="dropdown-menu" aria-labelledby="dropdownId">
          <a class="dropdown-item" href="#">Add Student Detail</a>
          <a class="dropdown-item" href="#">Delete Student Detail</a>
        </div>
      </li> 
        <%//} %>
    </ul>
    <ul class="navbar-nav ml-auto mt-2 mt-lg-0"> 
  	    <%  if(tempLoginStaff!=null){  %>
  	           <li class="nav-item active">
                 <a class="nav-link" href="staffoperation.jsp">Home </a>
               </li>
               <li class="nav-item active">
                 <a class="nav-link" >Welcome <%=loggedInStaff %> </a>
               </li>
              <li class="nav-item active">
                 <a class="nav-link" href="StaffLogoutServlet">Logout</a>
               </li>
            <% } else { %>
              
               <li class="nav-item active">
               <a class="nav-link" href="stafflogin.jsp?">Login</a>
             </li>
             <li class="nav-item active">
               <a class="nav-link" href="staffregister.jsp?">Register</a>
              </li>
           <% } %>    
      </ul>
  </div>
</nav>
</header>