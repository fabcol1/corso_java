<%@page import="org.bean.User"%>
<%@page import="org.db.UserDBManager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER SELECTION</title>

<%


 List <User> users = UserDBManager.getUsers();



%>


</head>

<body>
    	


	<%
	
	    for (int i = 0; i < users.size(); i++) {
				
	    	
	    	out.print ("<fieldset> <form action = 'userDetails.jsp'><li><a name = 'utente' value = '" + users.get(i).getEmail() + "'>"+users.get(i).getEmail()+ " - " + users.get(i).getFirstname() + " " + users.get(i).getLastname() +  "</a></li>");
	    	out.print("</fieldset> <button type = 'submit' name = 'button' value = '" + users.get(i).getId() + "' > MODIFICA </button></form>  <br><br>" );
	    	
			
	    	
	        
	    	
	   		 }
	
	

	
		
		
			
			
							
			
    %>

    


</body>
</html>