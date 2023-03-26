<%@page import="model.TrainerDAO"%>
<%@page import="model.Trainer"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>Edit Trainers</title>
  <link rel="stylesheet" href="css/TrainEdit.css" />
  
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
  
  <%
  TrainerDAO trainerDAO = new TrainerDAO("jdbc:mysql://localhost:3306/ustfits?useSSL=false", "root", "root");

  // Get the trainer to be edited based on the ID passed as a query parameter
  int id = Integer.parseInt(request.getParameter("id"));
  Trainer trainer = trainerDAO.getTrainerById(id);
%>
  
  
  
  

  <body>
  <div class="picture-container"></div>
  <div class="center-div">
    <h1>Edit Trainer</h1>
    <form action="update" method="PUT" enctype="multipart/form-data">
      <input type="hidden" name="id" value="<%=trainer.getId()%>">

      <div class="content">
        <label class="content-label">Name:</label>
        <input type="text" name="name" value="<%=trainer.getName()%>" class="content-input">
      </div>

      <div class="content">
        <label class="content-label">Specialty:</label>
        <input type="text" name="specialty" value="<%=trainer.getSpecialty()%>" class="content-input">
      </div>

      <div class="content">
        <label class="content-label">Sport:</label>
        <input type="text" name="sports" value="<%=trainer.getSports()%>" class="content-input">
      </div>

      <!--
      <div class="content">
        <label class="content-label">Photo:</label>
        <input type="file" name="photo" class="content-input">
      </div>
      -->

      <div class="button-container">
        <input type="submit" value="Update" class="button">
      </div>
    </form>
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