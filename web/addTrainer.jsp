<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>Edit Equipment</title>
   <style>
     body {
	font-family: Helvetica;
        background-color: #e5e9ec;
    }
    /* Add styles for the header */
    header {
      background-color: #333;
      color: #fff;
      display: flex;
      align-items: center;
      height: 50px;
      padding: 0 20px;
      position: fixed;
      top: 0;
      width: 100%;
      z-index: 1;
       left: 0;
    }
    /* Add styles for the hamburger menu */
    .menu-toggle {
      display: flex;
      align-items: center;
      justify-content: center;
      height: 50px;
      width: 50px;
      background-color: #333;
      color: #fff;
      cursor: pointer;
    }
    /* Add styles for the icon */
    span {
      font-size: 20px;
      margin-right: 20px;
    }
    /* Hide the menu by default */
    nav {
      display: none;
      background-color: #333;
      color: #fff;
      position: fixed;
      top: 50px;
      left: 0;
      width: 200px;
      font-family:Helvetica;
      

    }
    /* Show the menu when the hamburger menu is clicked */
    .show-menu {
      display: block;
    }
    /* Add styles for the menu items */
    nav a {
      display: block;
      padding: 20px;
      color: #fff;
      text-decoration: none;
    }
    /*       BACKGROUND        */
    .picture-container {
      background-image: url("ipeapic.jpg");
      background-size: cover;
      padding-bottom: 500px;
      height: calc(100% - 50px - 3px);
     
      top: 53px;
      width: 100%;
      z-index: -1;
    }
    
    
    
    
    
  
		.center-div {
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
			background-color: #F9E660;
			padding: 20px;
			text-align: center;
			box-shadow: 0px 0px 10px #888;
			border-radius: 10px;
			width: 500px;
		}
		
		.content {
			display: flex;
			flex-direction: row;
			align-items: center;
			justify-content: center;
			margin-bottom: 10px;
		}
		
		.content-label {
			margin-right: 10px;
			width: 100px;
			text-align: right;
			font-weight: bold;
		}
		
		.content-input {
			flex: 1;
			padding: 5px;
			border-radius: 5px;
			border: 1px solid #ccc;
		}
		
		.image-placeholder {
			margin-top: 20px;
			height: 200px;
			width: 300px;
			background-color: #ccc;
			border-radius: 5px;
		}
		
		.button-container {
			margin-top: 20px;
		}
		
		.button {
			padding: 10px;
			background-color: #4CAF50;
			color: white;
			border: none;
			border-radius: 5px;
			font-size: 16px;
			cursor: pointer;
		}
		
		.button:hover {
			background-color: #3e8e41;
		}
    
    
    
    
    
    
    
    
    
    /* Add styles for the footer */
    footer {
      background-color: #333;
      color: #fff;
      display: flex;
      align-items: center;
      height: 50px;
      justify-content: center;
      position: fixed;
      bottom: 0;
      width: 100%;
      font-family:Helvetica;
       left: 0;
    }
    
    
    .header-name {
  position: absolute;
  top: 0;
  right: 80px;
  height: 50px;
  display: flex;
  align-items: center;
  color: #fff;
  font-size: 18px;
   font-family:Helvetica;
}
    
    
    
    
    /* Add styles for the yellow line under the header */
    .header-line {
      background-color: #ff0;
      height: 3px;
      width: 100%;
      position: fixed;
      top: 50px;
      z-index: 0;
       left: 0;
    }
  </style>
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
      <a href="homepage.jsp">Home</a>
      <a href="#">View User Log</a>
      <a href="#">Equipment</a>
      <a href="#">Trainers</a>
      <a href="#">Add Account</a>
      <a href="#">Logout</a>
    </nav>
  </header>
  
  <!-- Add the yellow line under the header -->
  <div class="header-line"></div>
  
  <div class="picture-container"></div>
  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->
  
  
  
  
  
  
  
  
 
  <form method="POST" action="<%= request.getContextPath() %>/register">
    <div class="center-div">
        <div class="content">
            <div class="content-label">Name:</div>
            <input class="content-input" type="text" name="name" placeholder="Enter Name">
        </div>
        <div class="content">
            <div class="content-label">Specialty:</div>
            <input class="content-input" type="text" name="specialty" placeholder="Enter Specialty">
        </div>
        <div class="content">
            <div class="content-label">Sport:</div>
            <input class="content-input" type="text" name="sports" placeholder="Enter Sport">
        </div>
        <!--  <center><div class="image-placeholder"></div></center>    -->  
       
        <div class="button-container">
            <input type="submit" value="Save" class="button">
        </div>
    </div>
</form>

  
  
  
  
  
  
  
  
  
  
  
  
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