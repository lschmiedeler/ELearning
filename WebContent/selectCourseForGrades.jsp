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
  		Enter Grades
  		</p>
    	
    	<h2>Select Course</h2>
    	    	
    	<s:form action = "selectAssignmentForGrades">
    	
   		<s:select label = "Select Course"
   		list="selectCourseList" 
        name="assignmentCourse" 
        value="1" />
        
        <s:submit value = "Select Course"/><br>
    	
    	</s:form>
    	
    	<br><br><br><br>
    	
    	<a href="<s:url action='returnToDashboard'/>" style="font-size: 20px">Return to Dashboard</a>
    	
    	<br>
    	
    	<a href="<s:url action='logout'/>" style="font-size: 20px">Logout</a>
  	</body>
</html>