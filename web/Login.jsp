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
  <title>Login</title>
  <link rel="stylesheet" href="css/Login.css" />
  
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
  
  <!-- WEBPAGE CONTENT HERE -->
  
  
  
  
   <div class="center">
      <i class="icon fas fa-user-circle"></i>
      <h2>Login</h2>
        <form method="post" action="login">
    
        <label for="username" style="margin-left: 10px;">Username:</label>
        <input type="text" name="username">
        <br><br>
        
        <label for="password">Password:&nbsp;&nbsp;</label>
        <input type="password" name="password">
        <br><br>
        
        <input type="submit" value="Login">
        </form>
      
      <br>
      <a href="forgotPassword.jsp" style="color: black;">Forgot Password?</a>
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