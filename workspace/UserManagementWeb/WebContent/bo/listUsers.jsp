
<%@page import="org.db.UserDBManagerBO"%>
<%@page import="org.entities.User" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script >
function submitform(form_id){
	//alert("delete ");
	console.log("safe to delete"+ form_id);
	var frm = document.getElementById('form_id'+ form_id);
	frm.action="delete.jsp";
	frm.submit();

// 	if((frm==null)||(frm.length==0)){
// 		document.getElementById("emailErrorMessage").style.display= 'block';
// 		return;
// 	}
// 	else{
// 		document.getElementById("emailErrorMessage").style.display= 'none';
// 	}
// 	document.getElementById("submitform").action="ko.html";
// 	document.getElementById("submitform").submit();
	
	}

</script>
<body>


<ul >

<%
//String fname =User.getFirstname();
//String lname = selected.getLastname();
List<User> utenti = UserDBManagerBO.getAllUsers();
System.out.println(utenti.size());

for(User currentUser:utenti){
	out.println("<li> - " +  currentUser.getLastname() + " - " + currentUser.getFirstname()+" - "+ currentUser.getEmail()+ " - "+currentUser.getPassword()+ "<form id='form_id" + currentUser.getId() + "' action='update.jsp'>"+
    "<input type='hidden' name='id' value='" + currentUser.getId()+ "'><input type='submit'/><input type='button' onclick='submitform("+currentUser.getId()+");' value ='Delete'/></form></li>");
	
// 	out.print("<br>");
}

%>
</ul>


</body>
</html>

<!-- for(User currentUser:utenti){ -->
<!-- 	out.println("<li> - " +  currentUser.getLastname() + " - " + currentUser.getFirstname()+" - "+ currentUser.getEmail()+ " - "+currentUser.getPassword()+ "<form action='update.jsp'>"+ -->
<!--     "<input type='hidden' name='id' value='" + currentUser.getId()+ "'><input type='submit'/><form action='delete.jsp'></form></li>"); -->
