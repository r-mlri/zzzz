<%-- 
    Document   : index
    Created on : 01 30, 23, 10:36:01 AM
    Author     : Jayvee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Forgot Password</title>
   <style>
     body {
	font-family: Helvetica;
        background-image: url("Pictures/ustlight.jpg");
        background-size: cover;
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
    /*                  THIS PART IS FOR THE BACKGROUND
    .picture-container {
      background-image: url("#");
      background-size: contain;
      height: calc(100% - 50px - 3px);
      position: fixed;
      top: 53px;
      width: 100%;
      z-index: -1;
    }
    */
    
    
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
      left: 0;
      width: 100%;
    }
    /* Add styles for the yellow line under the header */
    .header-line {
      background-color: #ff0;
      height: 3px;
      width: 100%;
      position: fixed;
      top: 50px;
      left: 0;
      z-index: 0;
    }
     .center {
        background-color: yellow;
        padding: 20px;
        width: 50%;
        margin: auto;
        text-align: center;
        border-radius: 25px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
      }

      h2 {
        font-family: Arial, sans-serif;
        font-size: 36px;
        color: black;
      }

      form {
        font-family: Arial, sans-serif;
        font-size: 18px;
        color: black;
        margin-top: 50px;
      }

      .icon {
        font-size: 72px;
        margin-bottom: 50px;
      }

      input[type="submit"] {
        background-color: black;
        border: none;
        border-radius: 25px;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin-top: 20px;
      }

      .username-icon {
        font-size: 36px;
        margin-bottom: 10px;
      }
  </style>
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
      <a href="StudentLog.jsp">Student Log</a>
      <a href="StudentExit.jsp">Student Exit</a>
      <a href="Login.jsp">Personnel Login</a>
    </nav>
  </header>
  
  <!-- Add the yellow line under the header -->
  <div class="header-line"></div>
  
  <!-- WEBPAGE CONTENT HERE -->
  
  
  
  
   <div class="center">
      <i class="icon fas fa-user-circle"></i>
      <h2>Reset Password</h2>
      
     <form method ="get" action="forgotPassController">
        <label for="username" style="margin-left: 10px;">Username:</label>
        <input type="text" id="username" name="username" required>
        <br><br>
        
        <label for="password">New Password:</label>
        <input type="password" id="password" name="password" required>
        <br><br>
        
        <label for="pin">Reset Pin:&nbsp;&nbsp;</label>
        <input type="number" id="pin" name="pin" required>
        <br><br>
        
        <input type="submit" value="Reset">
        <input type="hidden" name="hidden" value="reset">
      </form>
      
      <br>
      
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