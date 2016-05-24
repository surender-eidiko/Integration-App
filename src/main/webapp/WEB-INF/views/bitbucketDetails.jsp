<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bitbucket Rooms Details</title>
</head>
<body>

<form:form method="POST" commandName="processForm">
Rooms : 
<form:select path="rooms">
   <form:option value="NONE" label="--- Select ---"/>
   <form:options items="${roomsList}" />
</form:select>

Repository :
<form:select path="repos">
   <form:option value="NONE" label="--- Select ---"/>
   <form:options items="${reposList}" />
</form:select>
<form:button ></form:button>
</form:form>
</body>
</html>