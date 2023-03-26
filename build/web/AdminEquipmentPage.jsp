<%@ page import="model.*" %>
   <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>Admin View Equipment Page</title>
  <link rel="stylesheet" href="css/adminjsps.css" />
  
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
  

  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->
	
  
  
  <br><br><br>
  
  
  
  
  <div class="container">
		<center><h1>Equipment List</h1>
		<table>
			<thead>
				<tr>
					<th>Image</th>
					<th>Equipment Name</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>Muscle Group</th>
                    <th> Action </th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="image"><img src="https://via.placeholder.com/150"></td>
					<td>lorem ipsum</td>
					<td>lorem ipsumlorem ipsumlorem ipsumlorem ipsum</td>
					<td>3</td>
					<td>lorem ipsum</td>
                   <td> <input type="button" value="Edit"></td>
				</tr>
				<tr>
					<td class="image"><img src="https://via.placeholder.com/150"></td>
					<td>lorem ipsumlorem ipsum</td>
					<td>lorem ipsumlorem ipsumlorem ipsum.</td>
					<td>5</td>
					<td>lorem ipsum</td>
                     <td> <input type="button" value="Edit"></td>
				</tr>
				<tr>
					<td class="image"><img src="https://via.placeholder.com/150"></td>
					<td>Skid Steer Loader</td>
					<td>lorem ipsumlorem ipsum</td>
                     <td>4</td>
                       <td>lorem ipsum</td>
                     <td> <input type="button" value="Edit"></td>
                 </tbody>
                 </table>
              </div>
  
  
  <br><br><br>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
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