<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trello Integration</title>
</head>
<body>
	<div>
		<div style="widows: 40%;margin-left: 200px"><img src='<c:url value="/images/trello.png"></c:url>' alt="Trello Icon" width="40" width="35"/></div>
		
		<div style="width: 60%;float: right">
			Trello is a project management tool that uses boards to keep your team organized.
			<br/>
			<h4><b>What does this integration do?</b></h4>
			Help your teams fnish projects faster. This integration allows you to follow a Trelloboard and post updated in a
spark room whenever an activity on that board occurs. Activities include things like a new card created, an update
to a card or a card moved.
<form:form action="code">
	<input type="submit" value="Add">
</form:form>
		</div>
	</div>
</body>
</html>