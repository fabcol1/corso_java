<%@page import="org.db.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifiche effettuate</title>
</head>
<body>


<%
String idUser=request.getParameter("id");
int id =Integer.parseInt(idUser);
String email=request.getParameter("email");
String password=request.getParameter("password");
String firstname=request.getParameter("firstname");
String lastname=request.getParameter("lastname");
String borndate=request.getParameter("borndate");

//UserDBManager.updateUserById(id, email, password, firstname, lastname, borndate);
	out.println("<p>Modifiche effettuate, torna all'elenco utenti.");
	out.println("<p><a href=\"homeManagement.jsp\">Elenco Utenti</a>");
%> 



</body>
</html>