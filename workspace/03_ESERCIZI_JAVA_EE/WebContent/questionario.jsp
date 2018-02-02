<%@page import="servlet.DBManager"%>
<%@page import="servlet.Topic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	Topic[] topics = DBManager.getTopics();
	int topicsSize = topics.length;
	session.setAttribute("topicSize", topicsSize);
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="questionarioAnswer.jsp">
<%
	for(int i = 0; i<topicsSize; i++) {
	%>
	<div> 
	<%
		out.print(topics[i].getQuestion()+"</br>");
		session.setAttribute("question"+String.valueOf(i), topics[i].getQuestion());
		
		int availableRepliesLength = topics[i].getAvailableReplies().length;
		String[] availableReplies = topics[i].getAvailableReplies();
		String[] correctReplies = topics[i].getCorrectReplies();
		session.setAttribute("correctReplies"+String.valueOf(i), correctReplies);
		
		for(int y=0; y < availableRepliesLength; y++) {
			out.print("<input type='checkbox' name='question"+String.valueOf(i)+"' value='"+availableReplies[y]+"' >"+availableReplies[y]+"<br>");
		}
		
		%>
		</div></br></br> 
		<%

	}

%>
<input type="submit" value="Verifica"/>
</form>
</body>
</html>