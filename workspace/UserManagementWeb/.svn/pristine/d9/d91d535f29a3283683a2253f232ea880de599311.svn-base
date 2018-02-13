<%@page import="org.db.UserDBManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MOD CONFIRMATION PAGE</title>

<meta http-equiv="refresh" content="5; url=http://localhost:8080/UserManagementWeb/homeManagement.jsp" />

</head>
<body>



<%
	

	String idUser = request.getParameter("id");
    int id = Integer.parseInt(idUser);
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String firstName = request.getParameter("first");
	String lastName = request.getParameter("last");
	String bornDate = request.getParameter("borndate");

	UserDBManager.updateuserById(id, email, password, firstName, lastName, bornDate);

    out.print ("Modifiche effettuate. Sarai reindirizzato entro 5 secondi alla pagina principale, ");
    out.print ("oppure clicca <a href='http://localhost:8080/GestioneUtenze/homeManagement.jsp'>QUI</a> per non attendere.");
    
    



%>


</body>
</html>