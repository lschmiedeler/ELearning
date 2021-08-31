<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>E-Learning System</title>
  	</head>
  	
  	<link href="css/global.css" rel="stylesheet" type="text/css">
	<body>
  		<p style="color: #ff4411;font-size: 48px;font-family: 'Signika', sans-serif;padding-bottom: 10px;text-align:center">
  		ELearning Dashboard
  		</p>
  		<h1>Edit a Course</h1>
  		
  		<div style="width: 100%; height: 175px; overflow: auto; align: center;">
  		  		
  			<table border=1 frame=void rules=rows class="grid id="myTable" style="margin-left: auto; margin-right: auto;">
  			<!-- Define colgroup to specify spacing -->
  				<colgroup>
  					<col span="1" style="width: 0%;">
  					<col span="1" style="width: 30%;">
  					<col span="1" style="width: 30%;">
  					<col span="1" style="width: 20%;">
  					<col span="1" style="width: 20%;">
  				</colgroup>
  			
  				<thead>
  					<tr>
  						<!-- first display none id used for aligning/default display-->
  						<th style="display: none;" align="center">id</th>
  						<th onclick="sortTable(1)" align="center">Course</th>
  						<th onclick="sortTable(2)" align="center">Term</th>
  						<th onclick="sortTable(3)" align="center">Description</th>
  						<th onclick="sortTable(4)" align="center">Students</th>
  					</tr>
  				</thead>
  				<tbody>
  					<tr>
  						<input type="submit" value="Edit">
  						<td style="display: none;" property_value="0" property_name="id" align="center">0</td>
  						<td property_value="Intro to CS" property_name="Course" align="center">Intro to CS</td>
  						<td property_value="Spring" property_name="Term" align="center">Spring</td>
  						<td property_value="Learn to program in Java" property_name="Description" align="center">Learn to program in Java</td>
  						<td property_value="List of students" property_name="Students" align="center">
  							<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
							<label for="student1"> student name 1</label><br>
							<input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
							<label for="student2"> student name 2</label><br>
							<input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
							<label for="student3"> student name 3</label><br>
	  					</td>
  					</tr>
  					<tr>
  						<td style="display: none;" property_value="0" property_name="id" align="center">0</td>
  						<td property_value="Intro to Math" property_name="Course" align="center">Intro to Math</td>
  						<td property_value="Spring" property_name="Term" align="center">Spring</td>
  						<td property_value="Learn calculus" property_name="Description" align="center">Learn calculus</td>
  						<td property_value="List of students" property_name="Students" align="center">
							<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
							<label for="student1"> student name 1</label><br>
							<input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
							<label for="student2"> student name 2</label><br>
							<input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
							<label for="student3"> student name 3</label><br>
	  					</td>
  					</tr>
  					<tr>
  						<td style="display: none;" property_value="0" property_name="id" align="center">0</td>
  						<td property_value="Intermediate CS" property_name="Course" align="center">Intermediate CS</td>
  						<td property_value="Spring" property_name="Term" align="center">Spring</td>
  						<td property_value="More complex object oriented programming" property_name="Description" align="center">More complex object oriented programming</td>
  						<td property_value="List of students" property_name="Students" align="center">
  							<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
							<label for="student1"> student name 1</label><br>
							<input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
							<label for="student2"> student name 2</label><br>
							<input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
							<label for="student3"> student name 3</label><br>
	  					</td>
  					</tr>
  				</tbody>
  			</table>
  		</div>
  
 		<script type="text/javascript">
    		function ShowHideDiv(chkSubject) {
        		var dvSubject = document.getElementById("dvSubject");
        		dvSubject.style.display = chkSubject.checked ? "block" : "none";
    		}
    	</script>
    	
    	
    	<p><a href="<s:url action='logout'/>">Logout</a></p>
    	
  	</body>
</html>