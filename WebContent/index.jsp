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
  		Welcome!
    	<h2>Login or create a new account.</h2>
    	
    	<s:actionerror />
    	<s:actionmessage />
    	
        <s:form action = "login" >
        <s:textfield name = "username" label = "Enter Username" /><br>
        <s:password name = "password" label = "Enter Password" /><br>
        <s:submit value = "Login" align = "center"/>
        </s:form>
        
        <br><br>
        
        <a href="<s:url action='enterNewAccountInfo' />" style="font-size: 20px">Create New Account</a>
    </body>
    
    
</html>