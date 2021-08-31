<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="genericError.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>E-Learning System</title>
  	</head>
  	
  	<link href="css/global.css" rel="stylesheet" type="text/css">
	<body>
  		<p style="color: #ff4411;font-size: 48px;font-family: 'Signika', sans-serif;padding-bottom: 10px;text-align:center">
  		View Grades
  		</p>
  		
  		<div style="width: 100%; height: 175px; overflow: auto; align: center;">
  		  		
  			<table border=1 class="grid id=" style="margin-left: auto; margin-right: auto;">
  			<!-- Define colgroup to specify spacing -->
  				<colgroup>
  					<col span="1" style="width: 0%;">
  					<col span="1" style="width: 40%;">
  					<col span="1" style="width: 10%;">
  					<col span="1" style="width: 10%;">
  					<col span="1" style="width: 40%;">
  				</colgroup>
  			
  				<thead>
  					<tr>
  						<!-- first display none id used for aligning/default display-->
  						<th style="display: none;" align="center">id</th>
  						<th onclick="sortTable(1)" align="center">Student ID</th>
  						<th onclick="sortTable(2)" align="center">Student Name</th>
  						<th onclick="sortTable(3)" align="center">Points Earned</th>
  						<th onclick="sortTable(4)" align="center">Points Possible</th>
  					</tr>
  				</thead>
  				<tbody>
  					<s:iterator var="i" step="1" value="gradeListTeacher">
	  					<tr>
  						<td style="display: none;" align="center">0</td>
                			<td align="center"><s:property value="%{userID}"></s:property></td>
                			<td align="center"><s:property value="%{firstname}"></s:property> <s:property value="%{lastname}"></s:property></td>
                			<td align="center"><s:property value="%{pointsEarned}"></s:property></td>
                			<td align="center"><s:property value="%{totalPointsPossible}"></s:property></td>
	  					</tr>
  					</s:iterator>
  				</tbody>
  			</table>
  		</div>
  		
  		<br><br><br><br>
    	
    	<a href="<s:url action='returnToDashboard'/>" style="font-size: 20px">Return to Dashboard</a>
    	
    	<br>
    	
    	<a href="<s:url action='logout'/>" style="font-size: 20px">Logout</a>    	
	</body> 	
</html>