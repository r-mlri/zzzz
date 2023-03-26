<%-- 
    Document   : index
    Created on : 01 30, 23, 10:36:01 AM
    Author     : Jayvee
--%>
<%@ page import="model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>SS User Logs</title>
  <link rel="stylesheet" href="css/UserLogs.css" />
  
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
      <a href="SSHomePage.jsp">Home</a>
      <a href="SSViewUserLog.jsp">View User Log</a>
      <a href="SSEquipmentsPage.jsp">Equipment</a>
      <a href="SSTrainersPage.jsp">Trainers</a>
      <a href=LogoutServlet>Logout</a>
    </nav>
  </header>
  
  <!-- Add the yellow line under the header -->
  <div class="header-line"></div>
  
  <!-- WEBPAGE CONTENT HERE -->
  
  
  
  
  
  
  
  
  <br><br><br><br>
  
  
  
  
 <div class="container">
     
		<h1>Student Log</h1>
	
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Student Number</th>
					<th>Entry Type</th>
					<th>Time Stamp</th>
					<th>Equipment(s) Used</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Jayvee Diaz</td>
					<td>1234567890</td>
					<td>Enter</td>
					<td>2023-03-07 09:30:00</td>
					<td>Equipment 1, Equipment 2</td>
					<td><button class="edit" type="button">Edit</button></td>
				</tr>
                 <tr>
					<td>Jayvee Diaz</td>
					<td>1234567890</td>
					<td>Exit</td>
					<td>2023-03-07 09:30:00</td>
					<td>Equipment 1, Equipment 2</td>
					<td><button class="edit" type="button">Edit</button></td>
				</tr>
			</tbody>
		</table>
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