   <%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>Equipments</title>
  <link rel="stylesheet" href="css/equipPage.css" />
  
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
  

  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->
	
  
  
  <br><br><br>
  
  
  
  
 <div class="container">
	<div class="header">
		<h1>Equipment List</h1>
		<div class="sort-by">
			<label for="sort-by">Sort By : </label>
			<select id="sort-by">
            	<option value="None">None</option>
				<option value="Upper Extremity">Upper Extremity</option>
				<option value="Lower Extemity">Lower Extemity</option>
				<option value="Core">Core</option>
			</select>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<th>Image</th>
				<th>Equipment Name</th>
				<th>Description</th>
				<th>Quantity</th>
				<th>Muscle Group</th>
			</tr>
		</thead>
		<tbody>
                    <c:forEach var="ustfits" items="${listEquipment}">
			<tr>
				<td class="image"><img src="https://via.placeholder.com/150"></td>
				<td><c:out value="${equipments.name}" /></td>
				<td><c:out value="${equipments.recommendation}" /></td>
				<td><c:out value="${equipments.quantity}" /></td>
				<td><c:out value="${equipments.picture}" /></td>
			</tr>
			<tr>
				<td class="image"><img src="https://via.placeholder.com/150"></td>
				<td><c:out value="${equipments.name}" /></td>
				<td><c:out value="${equipments.recommendation}" /></td>
				<td><c:out value="${equipments.quantity}" /></td>
				<td><c:out value="${equipments.picture}" /></td>
			</tr>
			<tr>
				<td class="image"><img src="https://via.placeholder.com/150"></td>
				<td><c:out value="${equipments.name}" /></td>
				<td><c:out value="${equipments.recommendation}" /></td>
				<td><c:out value="${equipments.quantity}" /></td>
				<td><c:out value="${equipments.picture}" /></td>
			</tr>
                    </c:forEach>
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