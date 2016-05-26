<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trello Integration with Spark</title>
</head>
<body>
<h3>Trello Integration</h3>
<form:form method="POST" commandName="trelloAppBean" action="formprocess">
	<label>Trello Boards :</label> 
	<form:select path="boardId">
		<form:option value="NONE"  label="Select Board"/>
	    <form:options items="${boards}"  />
	</form:select><br>
	<b>Notifications : Boards&List</b><br/>
	<form:checkboxes items="${boardNotifications }" path="boardsAndListNotifications"/><br>
<input type="submit" value="Integrate"/>
</form:form>
</body>
</html>