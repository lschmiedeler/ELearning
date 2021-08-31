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
  		Create an Account
  		</p>
    	<h2>Enter your account information.</h2>
    	
    	<s:actionerror />
    	
    	<s:form action = "createNewAccount">
    	
    	<s:textfield name = "firstname" label = "Enter First Name" required = "true"/><br>
    	
    	<s:textfield name = "lastname" label = "Enter Last Name" required = "true"/><br>
    	
    	<s:textfield name = "username" label = "Enter Username" required = "true"/><br>
    	
    	<s:password name = "password" label = "Enter Password" required = "true"/><br>
    	
    	<s:textfield name = "email" label = "Enter Email" required = "true"/><br>
    	
    	<s:radio list="{'student','teacher'}" name="role" multiple="false" checked = "true"></s:radio><br>	
    	
    	<s:submit value = "Create Account"/><br>
    	
    	</s:form>
  	</body>
</html>