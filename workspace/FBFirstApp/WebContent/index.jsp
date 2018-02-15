<%@page import="linkedin.commonthings"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>
Login With Linked In
</h1>


<a href="https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=<%=commonthings.client_id %>&redirect_uri=<%=commonthings.redirect_url %>&state=fdfdfdfd&scope=r_basicprofile%20r_emailaddress">

		<img alt="" src="Linkedin-customized-button.png" style="width: 10%">
</a>

</body>
</html>