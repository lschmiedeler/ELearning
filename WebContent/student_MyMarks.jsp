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
  		<h1>MyMarks</h1>
  		
  		<div style="width: 100%; height: 175px; overflow: auto; align: center;">
  		  		
  			<table border=1 frame=void rules=rows class="grid id="myTable" style="margin-left: auto; margin-right: auto;">
  			<!-- Define colgroup to specify spacing -->
  				<colgroup>
  					<col span="1" style="width: 0%;">
  					<col span="1" style="width: 40%;">
  					<col span="1" style="width: 40%;">
  					<col span="1" style="width: 10%;">
  					<col span="1" style="width: 10%;">
  				</colgroup>
  			
  				<thead>
  					<tr>
  						<!-- first display none id used for aligning/default display-->
  						<th style="display: none;" align="center">id</th>
  						<th onclick="sortTable(1)" align="center">Course</th>
  						<th onclick="sortTable(2)" align="center">Assignment Name</th>
  						<th onclick="sortTable(3)" align="center">Total Points</th>
  						<th onclick="sortTable(4)" align="center">Points Achieved</th>
  					</tr>
  				</thead>
  				<tbody>
  					<tr>
  						<td style="display: none;" property_value="0" property_name="id" align="center">0</td>
  						<td property_value="Intro to CS" property_name="Course Name" align="center">Intro to CS</td>
  						<td property_value="Quiz 1" property_name="Assignment Name" align="center">Quiz 1</td>
  						<td property_value="50" property_name="Total Points" align="center">50</td>
  						<td property_value="40" property_name="Points Achieved" align="center">40</td>
  					</tr>
  					<tr>
  						<td style="display: none;" property_value="0" property_name="id" align="center">0</td>
  						<td property_value="Intro to Math" property_name="Course Name" align="center">Intro to Math</td>
  						<td property_value="Quiz 2" property_name="Assignment Name" align="center">Quiz 2</td>
  						<td property_value="100" property_name="Total Points" align="center">100</td>
  						<td property_value="80" property_name="Points Achieved" align="center">80</td>
  					</tr>
  					<tr>
  						<td style="display: none;" property_value="0" property_name="id" align="center">0</td>
  						<td property_value="Intermediate CS" property_name="Course Name" align="center">Intermediate CS</td>
  						<td property_value="Test 1" property_name="Assignment Name" align="center">Test 1</td>
  						<td property_value="200" property_name="Total Points" align="center">200</td>
  						<td property_value="180" property_name="Points Achieved" align="center">180</td>
  					</tr>
  				</tbody>
  			</table>
  		</div>
  		
  		<div id="bottom">
    	<p><a href="<s:url action='logout'/>">Logout</a></p>
    	</div>
    	
	</body> 	
</html>
