<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%
//String loggedInStudent=(String)session.getAttribute("LOGGED_IN_STUDENT");
String tempLoginStudent=(String)session.getAttribute("TEMP_LOGIN_STUDENT");

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
     <% if(tempLoginStudent!= null){  %>
     <li class="nav-item active">
        <a class="nav-link" href="filldetails.jsp">Apply Scholarship & govt.Schemes</a>
      </li>
     <li class="nav-item active">
        <a class="nav-link" href="DisplayPersonalDetailsServlet">Pay fee</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="applybus.jsp">Apply Bus</a>
      </li>
      <%} %>
      
      <%//if(tempLoginStudent!=null){ %>
       <li class="nav-item dropdown">
        <a class="nav-link " href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
        <div class="dropdown-menu" aria-labelledby="dropdownId">
          <a class="dropdown-item" href="#"></a>
          <a class="dropdown-item" href="#"></a>
        </div>
      </li> 
        <%//} %>
    </ul>
    
    
    <ul class="navbar-nav ml-auto mt-2 mt-lg-0"> 
  	    <% if(tempLoginStudent!= null){  %>
  	           <li class="nav-item active">
                 <a class="nav-link" href="studentoperation.jsp">Home</a>
               </li>
               <li class="nav-item active">
                 <a class="nav-link">Welcome <%=tempLoginStudent %></a>
               </li>
              <li class="nav-item active">
                 <a class="nav-link" href="StudentLogoutServlet">Logout</a>
               </li>
          <% } else { %>
               <li class="nav-item active">
                 <a class="nav-link" href="studentlogin.jsp">Login</a>
               </li>
         <% } %>
      
      </ul>
       
      
       
   
  </div>
</nav>
</header>