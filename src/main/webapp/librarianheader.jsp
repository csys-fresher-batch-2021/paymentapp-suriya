<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%
//String loggedInLibrarian=(String)session.getAttribute("LOGGED_IN_LIBRARIAN");
String tempLoginLibrarian=(String)session.getAttribute("TEMP_LOGIN_LIBRARIAN");

%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp">Home</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
    <div class="collapse navbar-collapse" id="collapsibleNavId">
     <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <% if(tempLoginLibrarian!= null){  %>
       <li class="nav-item active">
        <a class="nav-link" href=""><span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="registerbook.jsp">Enroll Book</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="deregisterbook.jsp">Delist Enrolled Book</a>
      </li>
     <%} %>
      
      <%//if(tempLoginLibrarian!=null){ %>
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
  	    <% if(tempLoginLibrarian!= null){  %>
  	           <li class="nav-item active">
                 <a class="nav-link" href="librarianoperation.jsp">Welcome <%=tempLoginLibrarian %></a>
               </li>
              <li class="nav-item active">
                 <a class="nav-link" href="LibrarianLogoutServlet">Logout</a>
               </li>
          <% } else { %>
               <li class="nav-item active">
                 <a class="nav-link" href="librarianlogin.jsp">Login</a>
               </li>
         <% } %>
      
      </ul>
       
      
       
   
  </div>
</nav>
</header>