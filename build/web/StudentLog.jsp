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
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>Student Logs</title>
  <link rel="stylesheet" href="css/Students.css" />
  
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
  
  <div class="picture-container"></div>
  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->
  
  
  
  
  
  
  
  
  
  
  
   <div class="form-container">
      <h1>Student Log</h1>
         <form align="center" method="get" action="entryController">
            <input name="ID" type="number" size="50" placeholder="Student Number" required> <br> <br>
            <input type="submit" value="Enter">
            <input type="hidden" name="hidden" value="Entry"> 
         </form>
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