<%@page import="java.util.Date"%>
<%@page import="org.db.UserDBManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MOD CONFIRMATION PAGE</title>

<meta http-equiv="refresh" content="5; url=homeManagement.jsp" />
<link rel="stylesheet" type="text/css" href="css/confirm.css">


</head>
<body>
	   <div class = "main-box.no-header">
       <div class="main-box">

<%
	

	String idUser = request.getParameter("id");
    int id = Integer.parseInt(idUser);
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String bornDate = request.getParameter("borndate");
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date date = format.parse(bornDate);

	UserDBManager.updateUserById(id, email, password, firstName, lastName, date);

    out.print ("Modifiche effettuate. Sarai reindirizzato entro 5 secondi alla pagina principale, ");
    out.print ("oppure clicca <a href='homeManagement.jsp'>QUI</a> per non attendere.");
    
    



%>
</div>
</div>
</body>
</html>