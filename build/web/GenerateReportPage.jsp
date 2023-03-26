<%@ page import="model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>Admin Generate Reports</title>
  <link rel="stylesheet" href="css/GenReport.css" />
  
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
  
  
  
  
  
  
  
  
 
  
  
  
  
  
  
  <div class="container">
		<div class="left">
                    <center><h2>Report Generator</h2></center>
			<form>
                                <label for="table">Select Table</label>
                                 <select name="role">
                                 <option value="admin">students</option>
                                 <option value="support staff">trainers</option>
                                  <option value="support staff">equipments</option>
                                 </select>
				<input type="datetime-local" id="start" name="start">
				<label for="start">Start Time:</label>
				<input type="datetime-local" id="start" name="start">
				<label for="end">End Time:</label>
				<input type="datetime-local" id="end" name="end">
				<button type="button"id ="Time">Time</button>
                <button type="button" id ="Date">Date</button>
                 <button type="button" id ="Generate">Generate Report</button>
                
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