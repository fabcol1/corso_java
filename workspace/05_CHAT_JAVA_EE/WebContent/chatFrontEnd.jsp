<%@page import="test.MessagesRequest"%>
<%@page import="test.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/chatFrontEnd.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div class="text-read">
		<%
		MessagesRequest msgReq = new MessagesRequest();
		
		String last = (String) session.getAttribute("last");
		String email = (String) session.getAttribute("email");
		
		if(last!=null) {
			msgReq.setLastMessageSendTime(last);
		}
		
		Request req = new Request(msgReq); 
		String s = req.run();
		
		System.out.println("last: " + last + " email: " + email);
		
		session.setAttribute("last", msgReq.getLastMessageSendTime());
		out.print("<textarea rows='25' cols='75'> "+ s + " </textarea>");
		%>
		</div>
		<div class="text-form">
		<form action="SendMessage">
			<label>Message: </label>
			<input type="text" name="message"/>
			<input type="submit" value="Send"/><br><br>
		</form>
		
		<form action="chatFrontEnd.jsp">
			<input type="submit" value="Download last messages"/><br><br>
		</form>
		</div>
</body>
</html>