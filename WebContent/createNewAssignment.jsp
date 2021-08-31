<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="genericError.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<html>
  	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>E-Learning System</title>
    	<sx:head />
  	</head>
  	
  	<link href="css/global.css" rel="stylesheet" type="text/css">
  	  	
  	<style type="text/css">
    	.label {font-style:normal}
    	.tdLabel {text-align:left}    	
	</style>
  	
  	<body>
  	  	<p style="color: #ff4411;font-size: 48px;font-family: 'Signika', sans-serif;padding-bottom: 10px;text-align:center">
  		Create an Assignment
  		</p>
    	
    	<h2>Enter your assignment information.</h2>
    	
    	<s:actionerror />
    	
    	<s:form action = "createNewAssignment">
    	
    	<s:textfield name = "assignmentName"
    	label = "Enter Assignment Name"
    	required = "true"/><br>
    	
    	<sx:datetimepicker name="assignmentDueDate"
    	label="Select Due Date" 
    	displayFormat="dd-MMM-yyyy" value="%{'today'}"/>
    	
    	<s:select label="Select Course" 
        list="selectCourseList" 
        name="assignmentCourse" 
        value="1" />
        
        <s:submit value = "Create Assignment"/><br>
    	
    	</s:form>
    	
    	<br><br><br><br>
    	
    	<a href="<s:url action='returnToDashboard'/>" style="font-size: 20px">Return to Dashboard</a>
    	
    	<br>
    	
    	<a href="<s:url action='logout'/>" style="font-size: 20px">Logout</a>
  	</body>
</html>