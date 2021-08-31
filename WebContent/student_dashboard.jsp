<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="genericError.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>E-Learning System</title>
  	</head>
  	
  	<style>
	li { list-style: disc outside none; }
	</style>
  	
  	<link href="css/global.css" rel="stylesheet" type="text/css">
  	<link href="css/dash.css" rel="stylesheet" type="text/css">
  	
  	<body>
  		<p style="color: #ff4411;font-size: 48px;font-family: 'Signika', sans-serif;padding-bottom: 10px;text-align:center">
  		Student Dashboard
  		</p>
  		
  		<br>
    	
    	<b>Name:</b> <s:property value="firstname" />  <s:property value="lastname" />
    	<br>
    	<b>Username:</b> <s:property value="#session.username"/> 
    	<br>
    	<b>User ID:</b> <s:property value = "user_id" />
    	<br>
    	<b>Email:</b> <s:property value="email" />
    	<br>
    	<b>Role:</b> <s:property value="role" />
  		
  		<table style = "width: 100%">
	    <thead>
		    <tr>
		        <th><h2>Courses</h2></th>
		        <th><h2>Assignments</h2></th>
		        <th><h2>Teachers</h2></th>
		    </tr>
	    </thead>
	    <tbody>
	    	<tr align = "center" valign = "top">
	    		<td>
	    			<s:iterator var="i" step="1" value="courseList">
        				<b><u><s:property value = "courseName"></s:property></b></u>
        				<br>
        				<b>ID:</b> <s:property value = "courseID"></s:property>
        				<br>
        				<b>Subject:</b> <s:property value = "courseSubject"></s:property>
        				<br>
        				<b>Term:</b> <s:property value = "courseTerm"></s:property>
        				<br>
        				<b>Teacher:</b> <s:property value = "courseTeachers"></s:property>
        				<br>
        				<br>
    				</s:iterator>
    			</td>
    			<td >
    				<s:iterator var="i" step="1" value="assignmentList">
        				<b><u><s:property value = "assignmentName"></s:property></b></u>
        				<br>
        				<b>ID:</b> <s:property value = "assignmentID"></s:property>
        				<br>
        				<b>Course:</b> <s:property value = "assignmentCourse"></s:property>
        				<br>
        				<b>Due Date:</b> <s:property value = "assignmentDueDate"></s:property>
        				<br>
        				<br>
    				</s:iterator>
    			</td>
    			<td>
    				<s:iterator var="i" step="1" value="teacherList">
        				<b><u><s:property value = "firstname"></s:property> <s:property value = "lastname"></s:property></b></u>
        				<br>
        				<b>Username:</b> <s:property value = "username"></s:property>
        				<br>
        				<b>ID:</b> <s:property value = "userID"></s:property>
        				<br>
        				<b>Email: </b> <s:property value = "email"></s:property>
        				<br>
        				<br>
    				</s:iterator>   
    			</td>
	    	</tr>
	   	</tbody>
		</table>
		
    	<br><br>
    	
    	<a href="<s:url action='viewGradesStudent'/>"  style="font-size: 20px">View Grades</a>
    	<br>
    	<a href="<s:url action='logout'/>"  style="font-size: 20px">Logout</a>
    	
  	</body>
</html>