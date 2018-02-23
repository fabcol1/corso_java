<%@page import="org.db.UserDBManagerBO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<% 
String firstName = request.getParameter("firstName");
System.out.println("firstName:"+ firstName);
out.println("firstName:"+ firstName);
String lastName = request.getParameter("lastName");
System.out.println("lastName:"+ lastName);
out.println("lastName:"+ lastName);
String email = request.getParameter("email");
System.out.println("email:"+ email);
out.println("email:"+ email);
String password = request.getParameter("password");
System.out.println("password:"+ password);
out.println(    "password:"+ password);
String Borndate = request.getParameter("Borndate");
System.out.println("Borndate:"+ Borndate);
out.println("Borndate:"+ Borndate);
String Regdate = request.getParameter("Regdate");
System.out.println("Regdate:"+ Regdate);
out.println("Regdate:"+ Regdate);
int role = Integer.parseInt(request.getParameter("role"));
long id = Integer.parseInt(request.getParameter("id"));
System.out.println(id);
UserDBManagerBO.executeUpdateStmt(id,firstName,lastName,email,password,Borndate,Regdate,role);

%>


</body>
</html>