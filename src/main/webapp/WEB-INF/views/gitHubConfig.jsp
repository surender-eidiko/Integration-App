<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GitHub Integration with Spark</title>
</head>
<body>
<h3>GitHub Integration</h3>
<form:form method="POST" commandName="gitAppBean" action="saveconfig">
	<b>Repositories :</b>  
	<form:select path="repositories">
		<form:option value="NONE"  label="Select Repository"/>
	    <form:options items="${repos}"  />
	</form:select><br>
	
	<b>Events :</b><br><br>
	COMMIT EVENTS<br/>
	 <form:checkboxes items="${commitEvents }" path="commitEvents"/><br><br> 
	
	ISSUE / PULL REQUEST EVENTS <br/>
	<form:checkboxes items="${issueOrPullReqEvents }" path="issueOrPullReqEvents"/><br><br>
	
	DEPLOY EVENTS<br/>
	<form:checkbox path="deployEvents" value="deploymentstatus"/>Show deployment statuses<br/><br/>
	
	OTHER EVENTS<br/>
	<form:checkboxes items="${otherEvents }" path="otherEvents"/><br><br>
	
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
</html></html>