<%@page import="org.db.UserDBManager"%>
<%@page import="org.bean.User"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminazione utente</title>
</head>
<body>


<%
String idUser=request.getParameter("id");
int id =Integer.parseInt(idUser);


UserDBManager.deleteUserById(id);
	out.println("<p>Eliminazione utente effettuata, torna all'elenco utenti.");
	out.println("<p><a href=\"homeManagement.jsp\">Elenco Utenti</a>");
%> 



</body>
</html>