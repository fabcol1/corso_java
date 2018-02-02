<%@page import="servlet.DBManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	System.out.println("... pagina loginResponse.jsp");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String email = "pippo";
	String password = "pluto";
	boolean check = DBManager.checkOnDB(email, password);
	if(check) {
%>
		<p>LOGIN OK</p>
<%
	} else {
%>
	<p>LOGIN KO</p>
<%
	}
%>
</body>
</html>