<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="java.sql.*"%>
<%@ page import="org.db.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PAGINA DEL TOKEN</title>
</head>
<body>
<script>

function submit_by_id() {
	var token = document.getElementById("token").value;
	
	console.log(token);

	if (validation()) // Calling validation function
	{

		alert(" Token: " + token + document.getElementById("form_id").getAttribute("id")
				+ "\n\n IL CAMPO INSERITO SONO IN CORSO DI VALIDAZIONE... PER FAVORE ATTENDI.");

		document.getElementById("form_id").submit();
		
	}

}

//Funzione di Validazione Email e Password
function validation() {

	var token = document.getElementById("token").value;

	if (token == '') {
		alert("IL CAMPO E' VUOTO. INSERISCI IL TOKEN INVIATO NELLA CASELLA DI POSTA ELETTRONICA");
		return false;
	} else {	
		return true;		
	}	
}

</script>

<form action="ServletGeneratedToken" method="post" name="form_name" id="form_id"
		class="form_class">
		<h3>UN CODICE DI ATTIVAZIONE E' STATO APPENA INVIATO ALLA TUA E-MAIL. CONTROLLA IL CODICE ED INSERISCILO NEL CAMPO SOTTOSTANTE.</h3>
		<label>Token:</label> 
			<input type="text" name="token"id="token">
			<input type="submit" name="submit_token" id="token_id" value="VERIFICAMI E LOGGAMI"/>
	</form>
</body>
</html>