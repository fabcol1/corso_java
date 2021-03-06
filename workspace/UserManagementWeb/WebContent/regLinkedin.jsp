<%@page import="linkedin.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String code = request.getParameter("code");
	if (code == null || code.equals("")) {
		throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
	}
	
	PostTest objPost=new PostTest();
	LinkedInProfile linkedInProfile = null;
	try {
		linkedInProfile=objPost.sendPost(code);
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img
				src="images/proxima_logo.png"></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Link <span class="sr-only">(current)</span>
				</a></li>
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div class="container">
		<form class="form-horizontal divwith" method="post"
			action="RegistrationLinkedin">
			<!-- <div class="container-fluid"> -->
			<div class="form-group">
				<h4 class="lead">Per completare la registrazione con Linkedin inserisci una password</h4>
				<input type="text" class="form-control" name="fname"
					required="required" value="<%=linkedInProfile.getFirstName()%>" readonly>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="lname"
					value="<%=linkedInProfile.getLastName()%>" readonly>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="email"
					pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
					value="<%=linkedInProfile.getEmail()%>" readonly>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="pass" id="pass1"
					placeholder="Password" minlength="8" maxlength="50"
					required="required" autofocus>
			</div>
			<label id="pasw1format" style="color: red; display: none">la
				password deve essere lunga minimo 8 caratteri</label>
			<div class="form-group">
				<input type="password" class="form-control" name="passrep"
					id="pass2" placeholder="Ripeti passowrd" minlength="8"
					maxlength="50" required="required">
			</div>
			<label id="pswErrorMessage" style="color: red; display: none">le
				password non corrispondono</label>

			<div class="form-group">
				<input type="date" class="form-control" name="dateOfBirth"
					placeholder="Borndate">
			</div>
			
			<div class="form-group">
				
			</div>
			
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck"
						required="required"> <label class="form-check-label"
						for="gridCheck">Consenso utilizzo dati personali </label>
				</div>
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" name="pictureURL"
					value="<%=linkedInProfile.getPictureUrl()%>" readonly>
			</div>
			<div class="form-group row">
				<div class="col-sm-10">
					<input type="submit" value="Submit" class="btn btn-primary">
					<input type="reset" value="Reset" class="btn btn-primary">
				</div>
			</div>
		</form>
	</div>
	<script>

                                var pass = document.getElementById('pass1');
                                var passrep = document.getElementById('pass2');
                                pass.addEventListener("input", validationpsw);
                                passrep.addEventListener("input", validationpsw);
//                                pass.addEventListener("input", psw1Lenght);
//                                passrep.addEventListener("input", psw2Lenght);

//                                 function psw1Length() {



//                                 function psw2Length() {

//                                   if (pass.value.length < 8 || pass.value.length > 50) {
//                                     document.getElementById("pasw2format").style.display = 'block';
//                                   } else {
//                                     document.getElementById("pasw2format").style.display = 'none';
//                                   }
//                                 }

                                function validationpsw() {
                                    if (pass.value.length < 8 || pass.value.length > 50) {
                                        document.getElementById("pasw1format").style.display = 'block';
                                      } else {
                                        document.getElementById("pasw1format").style.display = 'none';
                                      }
                                    
                                
                                  if (pass.value != passrep.value && passrep.value != "") {
                                    document.getElementById("pswErrorMessage").style.display = 'block';
                                  } else {
                                    document.getElementById("pswErrorMessage").style.display = 'none';
                                  }
                                }
                              </script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>