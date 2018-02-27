<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.db.UserDBManager"%>
<%@page import="org.entities.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
AUTENTICAZIONE AVVENUTA CON SUCCESSO!
</body>
</html>
<%

User loggedUser = (User) session.getAttribute("loggedUser");

if (loggedUser!=null) {
	
} else {

	response.sendRedirect("index.jsp");
	
}

%>
