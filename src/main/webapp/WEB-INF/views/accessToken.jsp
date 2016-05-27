<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="javascript:invoke();">
Access Token : ${accessToken }
URL<%= request.getRequestURL().toString()%>
URI<%= request.getRequestURI().toString()%>
Header Names<%= request.getHeaderNames().toString() %>
PI<%= request.getPathInfo() %>
Pt<%= request.getPathTranslated() %>
Path Params<%= request.getParameterNames() %>
<c:set var="enumData" value="<%= request.getPathTranslated() %>"></c:set>
<c:forEach var="data" items="${enumData }">
	 DAta is :${data }
</c:forEach>
</body>
<script>
/* function invoke(){
	
	var url = window.location.hash;
	alert(url);
} */
</script>
</html>