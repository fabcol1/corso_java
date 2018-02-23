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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VERIFICA</title>
</head>
<body>
<% 

boolean st;

Class.forName("com.mysql.jdbc.Driver");

Connection con=DriverManager.getConnection
               ("jdbc:mysql://localhost:3306/utenti","root","");
PreparedStatement ps =con.prepareStatement
                    ("select * from users where email=? and password=?");
ps.setString(1, request.getParameter("nomeutente"));
ps.setString(2, request.getParameter("password"));
ResultSet rs = ps.executeQuery();
st = rs.next();

if (st == false) {
	
	request.getRequestDispatcher("ko.html").forward(request, response);
	
	
} else {
	
	request.getRequestDispatcher("token.jsp").forward(request, response);
	
}

%>
</body>
</html>