<!DOCTYPE html>
<html>
<head>
	<title>Trainers</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1">
     <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
	<link rel="stylesheet" href="css/TrainerPage.css" />
        
</head>
<body>


 <header>
    <!-- Add the hamburger menu -->
    <div class="menu-toggle">
      &#9776;
    </div>
    <!-- Add an icon to the header -->
     <span><img src= "Pictures/IPEA LOGO.png" > </span>
    <nav>
      <!-- Add the menu options -->
       <a href="index.jsp">Home</a>
      <a href="EquipmentPage.jsp">Equipments</a>
      <a href="TrainersPage.jsp">Trainers</a>
      <a href="StudentLog.jsp">Student Entry</a>
      <a href="StudentExit.jsp">Student Exit</a>
      <a href="Login.jsp">Login</a>
    </nav>
  </header>
  
  <!-- Add the yellow line under the header -->
  <div class="header-line"></div>
  

  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->


	<div class="hero">
		<h1>Meet Our Trainers</h1>
	</div>

	<div class="main-content">
		<div class="trainer">
			<center><img src="trainer1.jpg" alt="Trainer 1"></center>
			<div class="name">John Doe</div>
			<div class="sport">Basketball</div>
			<div class="specialty">Strength Training</div>
			
		</div>

		<div class="trainer">
		<center><img src="trainer2.jpg" alt="Trainer 2"></center>
			<div class="name">Jane Smith</div>
			<div class="sport">Yoga</div>
			<div class="specialty">Meditation</div>
			
		</div>
  
		<div class="trainer">
			<img src="trainer3.jpg" alt="Trainer 3">
			<div class="name">Mike Johnson</div>
			<div class="sport">Running</div>
			<div class="specialty">Endurance Training</div>
			
		</div>
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
