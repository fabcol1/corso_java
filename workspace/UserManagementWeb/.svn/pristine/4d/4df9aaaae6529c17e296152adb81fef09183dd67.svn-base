<%@page import="org.db.UserDBManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER DELETED CONFIRMATION</title>

<meta http-equiv="refresh" content="5; url=homeManagement.jsp" />
<link rel="stylesheet" type="text/css" href="css/confirm.css">

</head>
<body>

       <div class="main-box">


    <% 

    String idUser = request.getParameter("id");
    int id = Integer.parseInt(idUser);
    
    UserDBManager.deleteUserById(id);
    
    out.print ("Cancellazione effettuata. Sarai reindirizzato entro 5 secondi alla pagina principale, ");
    out.print ("oppure clicca <a href='homeManagement.jsp'>QUI</a> per non attendere.");

    %>

</div>
</body>
</html>