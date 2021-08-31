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
  		Create a Course
  		</p>
  		
  		<h2>Enter your course information.</h2>
  		
  		<s:actionerror />
  		
  		<s:form action = "createNewCourse">
  		
  		<s:textfield name="courseName" label="Enter Course Name" required = "true"/><br>
  		
		<s:select label="Select Term"
		name="term"
		list="#{'Summer':'Summer', 'Fall':'Fall', 'Winter':'Winter'}"
		value="1"/>
  		  		
  		<s:select label="Select Subject"
  		name="subject"
  		list="#{'Computer Science':'Computer Science', 'English':'English', 'History':'History',
  		'Math':'Math', 'Science':'Science'}"
  		value="1"/>
  		  		
  		<s:select label="Select Students"
        multiple = "true"
        list="selectStudentsList" 
        name="selectedStudents" 
        value="1" />
		
		<s:textfield name="description" label ="Enter Description" /><br>
  		
  		<s:submit value = "Create Course" /><br>
  		
  		</s:form>
    	
    	<br><br><br><br>
    	
    	<a href="<s:url action='returnToDashboard'/>" style="font-size: 20px">Return to Dashboard</a>
    	
    	<br>
    	
    	<a href="<s:url action='logout'/>" style="font-size: 20px">Logout</a>
  	</body>
</html>