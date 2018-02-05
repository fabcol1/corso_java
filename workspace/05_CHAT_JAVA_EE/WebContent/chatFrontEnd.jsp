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
		if(request.getAttribute("last")!=null) {
			msgReq.setLastMessageSendTime((String) request.getAttribute("last"));
		}
		Request req = new Request(msgReq); 
		String s = req.run();
		out.print("<textarea rows='25' cols='50'> "+ s + " </textarea>");
		request.setAttribute("last", msgReq.getLastMessageSendTime());
		%>
		</div>

		<div class="text-form">
		<form action="SendMessage">
			<label>Message: </label>
			<input type="text" name="message"/>
			<% out.print("<input type='hidden' name='email' value='"+request.getAttribute("email")+"' />"); %>
			<input type="submit" value="Send"/></br></br>
		</form>
		</div>
</body>
</html>