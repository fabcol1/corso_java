<%@page import="org.bean.User"%>
<%@page import="org.db.UserDBManager"%>
<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserDetails</title>
<link rel="stylesheet" type="text/css" href="css/main2.css">
<link rel="stylesheet" href="https://getbootstrap.com/docs/3.3/dist/css/bootstrap.min.css">
</head>

<body>
	<%
		String id = request.getParameter("button");
		User user = new User();
		user = UserDBManager.getUserById(Integer.parseInt(id));
	%>
	<div class="container">
		<%
			out.println("<h2>Dettaglio Utenza: " + user.getEmail() + "</h2><br>");
		%>
		<form class="form-horizontal divwidth"
			action="successfulinsertion.jsp">
			<div class="form-group">
				<label class="control-label col-sm-3 labelwidth" for="id">ID:</label>
				<div class="col-sm-9">
					<%
						out.println("<input type=\"text\" class=\"form-control\" id=\"idf\" name=\"idf\" value=\"" + user.getId()
								+ "\" disabled>");
					%>
					<%
						out.println("<input type=\"hidden\" class=\"form-control inputwidth\" id=\"id\" name=\"id\" value=\""
								+ user.getId() + "\" >");
					%>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3 labelwidth" for="email">Email:</label>
				<div class="col-sm-9">
					<%
						out.println("<input type=\"text\" class=\"form-control inputwidth\" id=\"email\" name=\"email\" value=\""
								+ user.getEmail() + "\" >");
					%>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3 labelwidth" for="password">Password:</label>
				<div class="col-sm-9">
					<%
						out.println(
								"<input type=\"text\" class=\"form-control inputwidth\" id=\"password\" name=\"password\" value=\""
										+ user.getPassword() + "\" >");
					%>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3 labelwidth" for="firstname">Firstname:</label>
				<div class="col-sm-9">
					<%
						out.println(
								"<input type=\"text\" class=\"form-control inputwidth\" id=\"firstname\" name=\"firstname\" value=\""
										+ user.getFirstname() + "\" >");
					%>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3 labelwidth" for="lastname">Lastname:</label>
				<div class="col-sm-9">
					<%
						out.println(
								"<input type=\"text\" class=\"form-control inputwidth\" id=\"lastname\" name=\"lastname\" value=\""
										+ user.getLastname() + "\" >");
					%>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3 labelwidth" for="borndate">Borndate:</label>
				<div class="col-sm-9">
					<%
						out.println(
								"<input type=\"date\" class=\"form-control inputwidth\" id=\"borndate\" name=\"borndate\" value=\""
										+ user.getBorndate() + "\" >");
					%>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3 labelwidth" for="regdate">Registration
					Date:</label>
				<div class="col-sm-9">
					<%
						out.println(
								"<input type=\"date\" class=\"form-control inputwidth\" id=\"regdate\" name=\"regdate\" value=\""
										+ user.getRegdate() + "\" disabled>");
					%>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<button type="submit" class="btn btn-default">Salva
						Modifiche</button>
				</div>
			</div>
		</form>
	</div>
	<div class="container">
		<form class="form-horizontal divwidth" action="successfuldelete.jsp">
			<div class="form-group">
				<!-- 				<label class="control-label col-sm-3 labelwidth" for="regdate"></label> -->
				<div class="col-sm-12">
					<%
						out.println("<input type=\"hidden\" name=\"id\" value=\"" + user.getId() + "\">");
					%>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="borndate">Delete
					User: </label>
				<div class="col-sm-9">
					<%
						out.println(
								"<input class=\"btn btn-default\" type=\"submit\" name='buttondelete' value=\"Elimina Utente\">");
					%>
				</div>
			</div>

		</form>
		<br> <br> <a href="homeManagement.jsp">Torna all'elenco utenti</a>
	</div>

</body>
</html>