<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Admin View Trainers Page</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1">
     <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
	<link rel="stylesheet" href="css/trainersAdmin.css" />
        
</head>
<body>


 <header>
    <!-- Add the hamburger menu -->
    <div class="menu-toggle">
      &#9776;
    </div>
    <!-- Add an icon to the header -->
     <span><img src= "Pictures/IPEA LOGO.png" > </span>
     <div class="header-name">
    <% 
     User user = (User) session.getAttribute("user"); 
     String username = user.getUsername();
    %>
     Welcome, <%= username %>
    </div>
    <nav>
      <!-- Add the menu options -->
     <a href="AdminHomePage.jsp">Home</a>
      <a href="AdminViewUserLog.jsp">View User Log</a>
      <a href="AdminEquipmentPage.jsp">Equipment</a>
      <a href="AdminTrainersPage.jsp">Trainers</a>
      <a href="AddAccount.jsp">Add Account</a>
      <a href="GenerateReportPage.jsp">Generate Reports</a>
      <a href=LogoutServlet>Logout</a>
    </nav>
  </header>
  
  <!-- Add the yellow line under the header -->
  <div class="header-line"></div>
  

  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->


	<div class="hero">
		<h1>Meet Our Trainers</h1>
	</div>

	<div class="main-content">
		<c:forEach var="trainer" items="${trainers}">
			<div class="trainer">
			<!--		<img src="\" alt="${trainer.name}">Put image in db first			--> 
				<div class="name">${trainer.name}</div>
				<div class="sport">${trainer.sports}</div>
				<div class="specialty">${trainer.specialty}</div>
				<div class="cta">
					<form action="edit" method="GET">
                                          <input type="hidden" name="id" value="${trainer.id}">
                                             <button type="submit">Edit</button>
                                          </form>
                                             <br>
					 <form action="delete" method="POST">
                                           <input type="hidden" name="id" value="${trainer.id}">
                                         <button type="submit">Delete</button>
                                          </form>
				</div>
			</div>
		</c:forEach>
            
            
                              <div class="trainer">
                                  <div class="cta">
					
                                            <a href="addTrainer.jsp"><button>Add Trainer?</button></a>
                                        
                                  </div></div>
            
            
            
            
            
	</div>
</body>







  
  <!-- Add the footer -->

  <footer>
    University of Santo Tomas ©2023
  </footer>

  <script>
    // Add JavaScript to toggle the menu
    const menuToggle = document.querySelector('.menu-toggle');
    const menu = document.querySelector('nav');
    menuToggle.addEventListener('click', () => {
      menu.classList.toggle('show-menu');
    });
  </script>
</body>
</html>
