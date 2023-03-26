<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>Edit Equipment</title>
  <link rel="stylesheet" href="css/EquipEdit.css" />
   
</head>
<body style="font-family:Helvetica; ">
  <header>
    <!-- Add the hamburger menu -->
    <div class="menu-toggle">
      &#9776;
    </div>
    <!-- Add an icon to the header -->
     <span><img src= "Pictures/IPEA LOGO.png" > </span>
    
    
     <div class="header-name">
    Hello, Name
  </div>
    
    
    
    <nav>
      <!-- Add the menu options -->
      <a href="index.jsp">Home</a>
      <a href="ViewUserLog.jsp">View User Log</a>
      <a href="EquipmentPage.jsp">Equipment</a>
      <a href="TrainersPage.jsp">Trainers</a>
      <a href="AddAccount.jsp">Add Account</a>
      <a href="/Logout">Logout</a>
    </nav>
  </header>
  
  <!-- Add the yellow line under the header -->
  <div class="header-line"></div>
  
  <div class="picture-container"></div>
  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->
  
  
  
  
  
  
  
  
 
  
  
  
  	<div class="center-div">
		<div class="content">
			<div class="content-label">Name:</div>
			<input class="content-input" type="text" placeholder="Enter name">
		</div>
		<div class="content">
			<div class="content-label">Muscle Group:</div>
			<input class="content-input" type="text" placeholder="Enter muscle group">
		</div>
		<div class="content">
			<div class="content-label">Quantity:</div>
			<input class="content-input" type="text" placeholder="Enter quantity">
		</div>
		<center><div class="image-placeholder"></div></center>
		<div class="button-container">
			<button class="button">Choose Image</button>
		</div>
		<div class="button-container">
			<button class="button">Save</button>
			<button class="button">Delete</button>
		</div>
	</div>
  
  
  
  
  
  
  
  
  
  
  
  
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