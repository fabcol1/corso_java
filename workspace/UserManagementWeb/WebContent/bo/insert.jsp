<%@page import="org.db.UserDBManagerBO"%>
<%@page import="org.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="afterInsert.jsp">


<input type="text" name ="firstName" value="mau" placeholder="firstName">
<input type="text" name ="lastName" value="mau" placeholder="lastName">
<input type="text" name ="email" value="mau" placeholder="email">
<input type="text" name ="password" value="mau" placeholder="password">
<input type="text" name ="role" value="1" placeholder="role">
<input type="submit">

</form>
</body>
</html>