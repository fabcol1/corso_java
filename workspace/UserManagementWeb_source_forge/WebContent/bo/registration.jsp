<%@page import="org.bean.User"%>
<%@page import="org.db.UserDBManagerBO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<%-- <% --%>
<!-- User curr = null; -->

<!-- String name = curr.getFirstname(); -->
<!-- %> -->
<form action="afterRegistration.jsp">
 First name:
 <input type="text" name ="firstName">
 <br>
 Last name:
 <input type="text" name ="lastName">
 <br>
 Email    :
 <input type="text" name ="email">
 <br>
 password :
 <input type="password" name = "password">
 <br>
 <input type="submit">
 
 </form>

</body>
</html>