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

<form:form method="POST" commandName="formBean" action="saveconfig">
<h3>Bitbucket Integration Settings</h3>
<h4>Post to channel</h4>
Which channel should we post exceptions to?
<form:select path="channelName">
   <form:option value="NONE" label="--- Select ---"/>
   <form:options items="${channelNames}" />
</form:select>
<br><br>
Webhook URL
<form:input path="webhookURL" value="${webhookURL }"/>
<br><br>
<h4>Descriptive Label</h4>
Use this label to provide extra context in your list of integrations (optional).
<form:input path="description" value="${description }"/>
<br><br>
Customize Name
<form:input path="displayName" value="Bitbucket"/>
<br><br>
Customize Icon
<input type="button" value="Upload Image"/>&nbsp;&nbsp;or&nbsp;&nbsp;<input type="button" value="Choose an emoji">
<br><br>
<input type="submit" value="Save Integration"/>
</form:form>
</body>
</html>