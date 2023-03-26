<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>Add Account</title>
  <link rel="stylesheet" href="css/addacc.css" />
  
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
  
  <div class="picture-container"></div>
  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->
  
  
  
  
  
  
  
  
  
  
  
   <div class="form-container">
      <h1>Add Account</h1>
      
      <form method="post" action="addAccountController">
          
        <label for="username">Username:</label>
        <input type="text" id="username" name="username">
        <br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <br><br>
        
   
         <select name="role">
         <option value="admin">admin</option>
         <option value="support staff">support staff</option>
         </select>
       
        <label for="pin">Reset Pin:</label>
        <input type="number" id="pin" name="pin">
        <br><br>
        
        <input type="submit" value="Add"> 
        <input type="hidden" name="hidden" value="create">
        
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