<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="WEB-INF/views/header.jsp"></jsp:include>
<body>
<h2>Connect All your Apps with Spark</h2>
<br>
<a href='<c:url value="/pagerduty/config"/>'>Configure PagerDuty</a><br>
<a href="<c:url value="/bitbucket/config"/>">Configure Bitbucket</a><br>
<a href="<c:url value="/jira/config"/>">Configure JIIRA</a><br>
<a href="<c:url value="/trello/config"/>">Configure Trello</a><br>

</body>
</html>