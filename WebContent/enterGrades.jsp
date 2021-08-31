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
    	
    	<h2>Enter Grades</h2>
    	    	
		<b>Assignment:</b> <s:property value = "selectedAssignment"/>
		<br>
		<b>Total Points Possible:</b> <s:property value = "totalPointsPossible"/>
		<br>
				
		<s:form action = "setGrades">
		<s:iterator var="student" step="1" value="studentList" status = "status">
        	<s:textfield name="studentList[%{#status.index}].pointsEarned"
        	label = "%{#student.firstname} %{#student.lastname} "/><br/>
        	<br>
    	</s:iterator>
    	<s:submit value="Submit"/>
		</s:form>
    	
    	<br><br><br><br>
    	
    	<a href="<s:url action='returnToDashboard'/>" style="font-size: 20px">Return to Dashboard</a>
    	
    	<br>
    	
    	<a href="<s:url action='logout'/>" style="font-size: 20px">Logout</a>
  	</body>
</html>