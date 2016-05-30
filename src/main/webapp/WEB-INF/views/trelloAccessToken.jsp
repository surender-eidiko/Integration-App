<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>trello access token page</title>
</head>
<body onload="javascript:invoke();">
Access Token :<p id="token"></p> 
<%-- <% 
	String at = "<script>document.writeln(url)</script>";
	out.println(at);
%> --%>
</body>
<script>
function invoke(){
	var url = window.location.hash;
	var token = url.slice(7);
	document.getElementById("token").innerHTML  = token;
	//alert(token.length);
	//alert(url);
} 
</script>
</html>