<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<form:form method="POST" commandName="pagerDutyConfigurationForm" action="saveintegration">
<h3>Integration Settings</h3>
<h4>Incidents to monitor</h4>

<h5>Choose the incidents you'd like to receive events for.</h5>

<form:checkboxes items="${incidents }" path="incidents"/>

<h3>Post to channel</h3>
<h5>Which channel should we post events to?</h5>
<form:select path="channelName">
   <form:option value="NONE" label="--- Select ---"/>
   <form:options items="${channelNames}" />
</form:select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br/><br/>

Webhook URL
<form:input path="webhookURL" value="${webhookURL }"/>
<br><br>
<h3>Descriptive Label</h3>
<h5>Use this label to provide extra context in your list of integrations (optional).</h5>
<form:input path="description" value="${description }"/>
<br><br>
Customize Name
<form:input path="displayName" value="pagerduty"/>
<br><br>
Customize Icon
<input type="button" value="Upload Image"/>&nbsp;&nbsp;or&nbsp;&nbsp;<input type="button" value="Choose an emoji">
<br><br>
<input type="submit" value="Save Integration"/>
</form:form>
</body>


