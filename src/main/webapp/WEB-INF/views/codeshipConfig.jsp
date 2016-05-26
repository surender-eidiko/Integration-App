<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Codeship Config</title>
</head>
<body>
<form:form method="POST" commandName="codeshipAppBean" action="formprocess">
<h2>Codeship Integration</h2>
	<b>Projects :</b>&nbsp;&nbsp;
	<form:select path="projects">
		<form:option value="NONE"  label="Select Project"/>
	    <form:options items="${projects}"  />
	</form:select><br>

	<h2>Spark Configuration</h2>
		Room : 
		<form:select path="roomId">
			<form:option value="NONE" label="--- Select ---" />
			<form:options items="${roomsList}" />
		</form:select>
		<br/><br/>
		Display Name:
		<form:input path="displayName" />
		<br />
<input type="submit" value="Integrate"/>
</form:form>
</body>
</html>