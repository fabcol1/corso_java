<%@page import="org.bean.User"%>
<%@page import="org.db.UserDBManager"%>
<%@page import="java.util.*"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Utente</title>
<link rel="stylesheet" type="text/css" href="css/main2.css">
<link rel="stylesheet" href="https://getbootstrap.com/docs/3.3/dist/css/bootstrap.min.css">
<%
	String id=request.getParameter("button");
	//User user=new User();
	//User user=UsersAccessDB.getUserById(Integer.parseInt(id));
	User user=UserDBManager.getUserById(Integer.parseInt(id));
	Gson gson=new GsonBuilder().setPrettyPrinting().create();
	String jsonInString = gson.toJson(user);
	//System.out.println(user);
	
%> 

<script language="javascript"> 
var obj = <%=jsonInString%>;
console.log(obj);
// document.getElementById("id").innerHTML = obj.id;
function clearInput(){
	document.getElementById("emailErrorMessage").style.display='none';
}

function deleteControl() {
	
    if (confirm("Are you sure you want to delete this user?")) {
        
    } else {
        return false;
    }    
}

function submitForm(){ 
 <%--  <% String email=user.getEmail(); %>
   var email="<%=email%>"; 
   alert(email);  --%>
   console.log("Sono qui nel submitForm");	
	var emailValue=document.getElementById("email").value;
	var passValue=document.getElementById("password").value;
	console.log("lunghezza stringa email: "+emailValue.length);		
	console.log("lunghezza stringa password: "+passValue.length);
	if (!validateEmail(emailValue)) {			
		return false;
	}
	if (!validatePassword(passValue)) {			
		return false;
	}
	//return 
	//document.getElementById("updateForm").action="modConfirm.jsp";
	//document.getElementById("updateForm").submit;
} 
function valForm(){
	var x = document.forms["updateForm"]["email"].value;
    if (x == "") {
        alert("email must be filled out");
        return false;
    }
}
function validateEmail(inputValue){
	var validationCheck=false;
	if ((inputValue==null)||(inputValue.length==0)) {
		document.getElementById("inputErrorMessage").style.display='block';
		validationCheck=false;
	}else {
		document.getElementById("inputErrorMessage").style.display='none';
		validationCheck=true;
	}
	return validationCheck;
}
function validatePassword(inputValue){
	var validationCheck=false;
	if ((inputValue==null)||(inputValue.length==0)) {
		document.getElementById("passwordErrorMessage").style.display='block';
		validationCheck=false;
	}else {
		document.getElementById("passwordErrorMessage").style.display='none';
		validationCheck=true;
	}
	return validationCheck;
}

</script> 
</head>
<body>

<div class="container">
 <script type="text/javascript">document.write("<h2>Dettaglio Utente: "+obj.email+"</h2><br>");</script>  
  <form class="form-horizontal divwidth"name="updateForm" action="modConfirm.jsp" id="updateForm" onsubmit="return submitForm()" method="post">
  	<div class="form-group">
      <label class="control-label col-sm-3 labelwidth" for="id">ID:</label> 
      <div class="col-sm-9">    
       <script> document.write("<input type='text' class='form-control' id='idf' name='idf'  value='"+obj.id+"' disabled>");</script>   
        <script>document.write("<input type='hidden' class='form-control inputwidth' id='id' name='id'  value='"+obj.id+"' >");</script>
      </div>
    </div>    
    <div class="form-group">
      <label class="control-label col-sm-3 labelwidth" for="email">Email:</label>
      <div class="col-sm-9">
        <script>document.write("<input type=\"text\" class=\"form-control inputwidth\" id=\"email\" name=\"email\" value=\""+obj.email+"\" >");</script>
      </div>
      <div class="col-sm-offset-3 col-sm-9">
        <label id="inputErrorMessage" style="color:red" hidden>Email non corretta</label>
      </div>      
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3 labelwidth" for="password">Password:</label>
      <div class="col-sm-9">          
        <script>document.write("<input type=\"text\" class=\"form-control inputwidth\" id=\"password\" name=\"password\" value=\""+obj.password+"\" >");</script>
      </div>
      <div class="col-sm-offset-3 col-sm-9">
        <label id="passwordErrorMessage" style="color:red" hidden>Password non corretta</label>
      </div>  
    </div>    
    <div class="form-group">
      <label class="control-label col-sm-3 labelwidth" for="firstname">Firstname:</label>
      <div class="col-sm-9">          
        <script>document.write("<input type=\"text\" class=\"form-control inputwidth\" id=\"firstname\" name=\"firstname\" value=\""+obj.firstname+"\" >");</script>
      </div>
    </div>    
    <div class="form-group">
      <label class="control-label col-sm-3 labelwidth" for="lastname">Lastname:</label>
      <div class="col-sm-9">          
        <script>document.write("<input type=\"text\" class=\"form-control inputwidth\" id=\"lastname\" name=\"lastname\" value=\""+obj.lastname+"\" >");</script>
      </div>
    </div>    
    <div class="form-group">
      <label class="control-label col-sm-3 labelwidth" for="borndate">Borndate:</label>
      <div class="col-sm-9">          
         <script>document.write("<input type=\"date\" class=\"form-control inputwidth\" id=\"borndate\" name=\"borndate\" value=\""+obj.borndate+"\" >");</script>
      </div>
    </div>    
    <div class="form-group">
      <label class="control-label col-sm-3 labelwidth" for="regdate">Registration Date:</label>
      <div class="col-sm-9">          
         <script>document.write("<input type=\"date\" class=\"form-control inputwidth\" id=\"regdate\" name=\"regdate\" value=\""+obj.regdate+"\" disabled>");</script>
      </div>
    </div>    
    <div class="form-group">        
      <div class="col-sm-offset-3 col-sm-9">
        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-floppy-save"></span> Salva Modifiche</button>
      </div>
    </div>
  </form>
 </div>
	<div class="container">
		<form class="form-horizontal divwidth" action="delConfirm.jsp">
			<div class="form-group">
<!-- 				<label class="control-label col-sm-3 labelwidth" for="regdate"></label> -->
				<div class="col-sm-12">
					<script>document.write("<input type=\"hidden\" name=\"id\" value=\""+obj.id+"\">");</script>
				</div>
			</div>
			<div class="form-group">
			<label class="control-label col-sm-3" for="borndate">Delete User: </label>
				<div class="col-sm-9">
					<script>document.write("<button class=\"btn btn-default\" onclick='return deleteControl()' type=\"submit\" name='buttondelete' value=\"Elimina Utente\"><span class='glyphicon glyphicon-trash'></span> Elimina Utente</button>");</script>
				</div>
			</div>

		</form>
		<br>
		<br> <a href="homeManagement.jsp"><span class="glyphicon glyphicon-th-list"></span> Torna all'elenco utenti</a>
	</div>

</body>
</html>