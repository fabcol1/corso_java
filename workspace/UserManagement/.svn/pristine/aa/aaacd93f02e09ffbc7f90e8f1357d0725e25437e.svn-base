<%@page import="entities.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.UsersAccessDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER SELECTION</title>

<%


ArrayList <User> users = UsersAccessDB.getUsers();



%>


</head>

<body>



	<%
	
	    for (int i = 0; i < users.size(); i++) {
				
	    	
	    	out.print("<ul><li><a href = 'userDetails.jsp' +  name = 'utente' value = '" + users.get(i).getEmail() + "'>"+users.get(i).getEmail()+"</a> </li></ul>");
	    	
			
	    	
	        
	    	
	    }
		
// 		UsersAccessDB.getID(request.getParameter("utente"));
		
		
		
			
			
							
			
    %>

    


</body>
</html>