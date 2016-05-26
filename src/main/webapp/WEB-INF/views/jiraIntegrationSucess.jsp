<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JIRA Integration</title>
</head>
<body>
<h2>JIRA Integration Details</h2>
JIRA Project Id:&nbsp;&nbsp; ${jiraAppBean.projectId}<br/>
Spark Room Id:&nbsp;&nbsp;&nbsp; ${jiraAppBean.roomId}<br/>
Display Name: &nbsp;&nbsp;&nbsp;&nbsp; ${jiraAppBean.displayName}<br/>
<br/>${jiraIntegrationData}
</body>
</html>