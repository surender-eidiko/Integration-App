<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="WEB-INF/views/header.jsp"></jsp:include>
<body>
Cisco Mule Project

<a href='<c:url value="/pagerduty/config"/>'>Configure PagerDuty</a>
<a href="<c:url value="/bitbucket/page"/>">Configure Bitbucket</a>
<a href="<c:url value="/jira/page"/>">Configure Trello</a>
</body>
</html>