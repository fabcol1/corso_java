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
String email = request.getParameter("email");
System.out.println("email:"+ email);
String password = request.getParameter("password");
System.out.println("password:"+ password);
//out.println("email:"+ email);
//out.println(    "password:"+ password);
boolean s =UserDBManagerBO.checkCredentials(email, password);
System.out.println("UserDBManagerBO.checkCredentials: " + s);

out.println(s );
if((s)){
	System.out.println("logIn Successful");
	out.println("logIn Successful");
	
}
else{
	System.out.println("please register first");
	out.println("OK");
	%>
	
	<jsp:forward page="registration.jsp" />

<%


}
%>






</body>
</html>