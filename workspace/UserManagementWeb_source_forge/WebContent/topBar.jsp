<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/navBar.css">




</head>
<body>



<div class="topnav" id= "topnav">
  <a href="http://www.proximainformatica.com/" target="_blank"><img class="img-responsive2"       
       src="./proxima_logo.png"></a>
  <a class="active" href="homeManagement.jsp">Gestione Utenti</a>
  <a href="http://blog.proximainformatica.com/" target="_blank">Blog</a>
  <a href="http://www.proximainformatica.com/proxima-informatica-academy/corsojava/" target="_blank">Centauri</a>
  <a href="index.html">Logout</a>
  <a href="javascript:void(0);" style="font-size:20px;" class="icon" onclick="myFunction()">&#9776;</a>
</div> 
<script>
function myFunction() {
    var x = document.getElementById("topnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}
</script>





</body>
</html>