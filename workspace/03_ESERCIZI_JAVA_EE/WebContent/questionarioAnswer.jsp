<%@page import="java.util.Arrays"%>
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
	int topicsSize = (int) session.getAttribute("topicSize");

	boolean correct[] = new boolean[topicsSize];
	for(int i = 0; i<topicsSize; i++) {
		String[] replies = (String[]) request.getParameterValues("question"+String.valueOf(i));
		String[] correctReplies = (String[]) session.getAttribute("correctReplies"+String.valueOf(i));
		
		out.print("Domanda n# " + (i+1) +": ");
		out.print((String) session.getAttribute("question"+String.valueOf(i)) );
		out.print("</br>");
		
		if(replies!=null && correctReplies!=null) {
			Arrays.sort(replies);
			Arrays.sort(correctReplies);
			if(Arrays.equals(replies, correctReplies)) {
				out.print("Hai risposto correttamente alla domanda n# " + (i+1) + "</br>");
				out.print("Come hai detto la riposta corretta è: " + Arrays.toString(correctReplies) + "</br></br>");
				correct[i] = true;
			} else {
				out.print("Hai sbagliato la domanda n# " + (i+1) + "</br>");
				out.print("La riposta corretta è: " + Arrays.toString(correctReplies) + "</br></br>");
				correct[i] = false;
			}
		} else {
			out.print("Hai sbagliato la domanda n# " + (i+1) + "</br>");
			out.print("La riposta corretta è: " + Arrays.toString(correctReplies) + "</br></br>");
			correct[i] = false;
		}
	}
	out.print("---------------------------------------------------------------------------------------------------------");
	int h = 0;
	for(boolean b : correct) {
		if(b) h++;
	}
%>
<p></br>Hai riposto correttamente a 
<% 
	out.print(h + " domande</br>");
	if(h>3) {
		out.print("Hai superato il Test");
	} else {
		out.print("Non hai superato il Test");

	}
%>
</br></p>

<form action="questionario.jsp">
<input type="submit" value="Prova ancora"/>
</form>
</body>
</html>