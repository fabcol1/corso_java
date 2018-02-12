<%@page import="org.bean.User"%>
<%@page import="org.db.UserDBManager"%>
<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserDetails</title>

    </head>

    <%

    String id = request.getParameter("button");
    
    User user = new User();

    out.print ("Modifica utente: ");
    
    
    
    user = UserDBManager.getUserById(Integer.parseInt(id));
    
    
    %>
    <body>
    
    <form action = 'modConfirm.jsp'>
    <br>
    <br>
    
    <% 
    
				
    
        out.print (" <p> ID: " +user.getId()+ " <input type = 'hidden' name = 'id' value = '" + user.getId() + "' /></p>");
        out.print (" <p> USER E-MAIL: <input type = 'text' name = 'email' value = '" + user.getEmail() + "' /></p>");
        out.print (" <p> USER PASSWORD: <input type = 'text' name = 'password' value = '" + user.getPassword() + "' /></p>");
        out.print (" <p> FIRST NAME: <input type = 'text' name = 'first' value = '" + user.getFirstname() + "' /></p>");
        out.print (" <p> LAST NAME: <input type = 'text' name = 'last' value = '" + user.getLastname() + "' /></p>");
        out.print (" <p> BORN: <input type = 'text' name = 'borndate' value = '" + user.getBorndate() + "' /></p>");
        out.print (" <p> REGISTERED: <input type = 'hidden' name = 'regdate' value = '" + user.getRegdate() + "' /></p>");
        out.print("  <button type = 'submit' name = 'savemod' value = 'savemod'> SALVA MODIFICHE </button></form>  <br><br>" );
    	
		
       
        
        

        
     %>
     
   

    </form>
    
    
    
      
    


   


</body>






</html>
