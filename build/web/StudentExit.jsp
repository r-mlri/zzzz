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
  <title>Leaving...</title>
  <link rel="stylesheet" href="css/Students.css" />
   <style>
      .form-container {
        background-color: #FFF192;
        width: 350px;
        height: 230px;
        margin: 100px auto;
        padding: 20px;
        border: 2px solid black;
        text-align: center;
        font-family: Arial, sans-serif;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.25);
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
      <a href="StudentLog.jsp">Student Entry</a>
      <a href="StudentExit.jsp">Student Exit</a>
      <a href="Login.jsp">Login</a>
    </nav>
  </header>
  
  <!-- Add the yellow line under the header -->
  <div class="header-line"></div>
  
  <div class="picture-container"></div>
  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->
  
  
  
  
  
  
  
  <br>  <br>  <br>
  
  
  
   <div class="form-container">
   <form align="center" method="get" action="exitController"> 
    <div style="display:flex;">
      <div style="flex:1;">
        <br>
        <label>Student Number:</label>
        <br>
        <br>
            <input name="ID" type="number" size="50" placeholder="Student Number" required> <br> <br>
            <input type="submit" value="Exit">
            <input type="hidden" name="hidden" value="Leave">
            <%
String errorMessage = (String) request.getAttribute("errorMessage");
if (errorMessage != null) {
%>
    <div class="error-message"><%= errorMessage %></div>
<%
}
%> 
      </div>
      <div style="flex:1;">
        <label>Equipment:</label>
        <div class="equipment-container">
          <input type="checkbox" name="equipment_1">Equipment 1<br>
          <input type="checkbox" name="equipment_2">Equipment 2<br>
          <input type="checkbox" name="equipment_3">Equipment 3<br>
          <input type="checkbox" name="equipment_4">Equipment 4<br>
          <input type="checkbox" name="equipment_5">Equipment 5<br>
          <input type="checkbox" name="equipment_6">Equipment 6<br>
          <input type="checkbox" name="equipment_7">Equipment 7<br>
          <input type="checkbox" name="equipment_8">Equipment 8<br>
          <input type="checkbox" name="equipment_9">Equipment 9<br>
          <input type="checkbox" name="equipment_10">Equipment 10<br>
          <input type="checkbox" name="equipment_11">Equipment 11<br>
          <input type="checkbox" name="equipment_12">Equipment 12<br>
          <input type="checkbox" name="equipment_13">Equipment 13<br>
          <input type="checkbox" name="equipment_14">Equipment 14<br>
          <input type="checkbox" name="equipment_15">Equipment 15<br>
          <input type="checkbox" name="equipment_16">Equipment 16<br>
          <input type="checkbox" name="equipment_17">Equipment 17<br>
          <input type="checkbox" name="equipment_18">Equipment 18<br>
          <input type="checkbox" name="equipment_19">Equipment 19<br>
          <input type="checkbox" name="equipment_20">Equipment 20<br>
        </div>
  </div>
  </div>
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