<%@page import="org.db.UserDBManagerBO"%>
<%@page import="org.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="afterUpdate.jsp">

<%


String userid = request.getParameter("id");
System.out.println("userid");
 int p = Integer.parseInt(userid) ; 
 System.out.println(p);
User selected = UserDBManagerBO.selectById(p);
System.out.println("User selected");

String name = selected.getFirstname();
String fname = selected.getFirstname();
String lname = selected.getLastname();
String lemail = selected.getEmail();
String lpass = selected.getEmail();
long lid = selected.getId();
int role = selected.getRole();


%>
<script type="text/javascript">
var curr = <%out.print(selected.toJSON());%>;
alert(curr.firstName);
</script>

<input type="text" name ="firstName" value="<%=fname%>">
<input type="text" name ="lastName" value="<%=lname%>">
<input type="text" name ="email" value="<%=lemail%>">
<input type="text" name ="password" value="<%=lpass%>">
<input type="text" name ="id" value="<%=lid%>">
<input type="text" name ="role" value="<%=role%>">
<input type="submit">

</form>
</body>
</html>