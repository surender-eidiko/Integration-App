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

<form:form method="POST" commandName="details" action="formprocess">
Rooms : 
<form:select path="room">
   <form:option value="NONE" label="--- Select ---"/>
   <form:options items="${roomsList}" />
</form:select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Repository :
<form:select path="repo">
   <form:option value="NONE" label="--- Select ---"/>
   <form:options items="${reposList}" />
</form:select>
<br/><br/>
<input type="submit" value="Integrate"/>
</form:form>
</body>
</html>