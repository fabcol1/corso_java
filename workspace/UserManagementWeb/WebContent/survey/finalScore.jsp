<%@page import="org.proxima.survey.frontutils.Evaluation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/finalScore.css">
<title>Your Score</title>
</head>
<body>
<%
if(session.getAttribute("evaluation")!=null) {
	Evaluation ev = (Evaluation)request.getSession().getAttribute("evaluation");
	System.out.println(ev.getUserID().toString());
	%>
	<div class="container">
	<h4>Your score is</h4>
	<h2><% out.print(ev.getPoints()); %></h2>
	<h4>out of <% out.print(Evaluation.getTotalQuestions()); %> questions!</h4>
	</div>
<%
}
else {
	%><div class="container">
	<h2 style="color: red">You should log in first!</h2>
	</div><%
}
%>

</body>
</html>