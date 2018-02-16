<%@page import="org.db.UserDBManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	
	<script type="text/javascript">
	
		var listValues = "<%out.print(UserDBManager.usersToJSON());%>";
		
		var array = JSON.parse( listValues );
		
		console.log(array);
	</script>
<body>
	<script>
	
	// firstName:"Abc",
	// lastName:"Def",
	// birthDate:"12-10-1979",
	// email: "abcdef@culokiz.com"
	
		document.write("<ul>");
		for(var i = 0; i < users.length; i++) {
			document.write("<li><input id='email' type='text' name='email' value='"+ users[i].email +"'/></li>")
			document.write("<li><input id='firstName' type='text' name='firstName' value='"+ users[i].firstName +"' /></li>");
			document.write("<li><input id='lastName' type='text' name='lastName' value='"+ users[i].lastName +"' /></li>");
			document.write("<li><input id='birthDate' type='text' name='birthDate' value='"+ users[i].birthDate +"' /></li>");
			document.write("<br><br>");
		}
		document.write("</ul>");
	</script>
		
</body>
</html>