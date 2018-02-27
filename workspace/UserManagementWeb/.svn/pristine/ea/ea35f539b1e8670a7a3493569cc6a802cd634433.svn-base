<%@page import="org.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/welcome.css">
<title>Welcome to our survey</title>
</head>
<body>
<div>
<h2> Welcome <% out.print("User: ID"); %> </h2><br>
<h4> Whenever you're ready, press the start button. </h4>
<%
User user = new User();
user.setId(28);
session.setAttribute("loggedUser", user);
%>
<input id="start"type="button" value="Start" onclick="window.location.href='survey.jsp'">
</div>

</body>
</html>