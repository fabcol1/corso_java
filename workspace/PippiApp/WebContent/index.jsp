<%@page import="linkedin.LinkedinConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	LinkedinConnection liConnection = new LinkedinConnection();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java LinkedIn Login</title>
</head>
<body style="text-align: center; margin: 0 auto;">
	<div style="margin: 0 auto; height: 360px; width: 610px;">
		<a href="<%=liConnection.getLIAuthUrl()%>"> <img
			style="margin-top: 138px;" src="./img/signInLinkedin.png" />
		</a>
	</div>
</body>
</html>