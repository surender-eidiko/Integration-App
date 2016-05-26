<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JIRA Project Details</title>
</head>
<body>

	<form:form method="POST" commandName="jiraAppBean" action="saveconfig">
		<h2>JIRA Configuration</h2>
		Repository :
		<form:select path="projectId">
			<form:option value="NONE" label="--- Select ---" />
			<form:options items="${projectsList}" />
		</form:select>

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
		<br />
		<input type="submit" value="Integrate" />
	</form:form>
</body>
</html>