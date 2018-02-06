<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://getbootstrap.com/docs/3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<%
	session.invalidate();
%>
<title>LOGIN</title>
</head>
<body>

	<div class="container">
	 
	 <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="login.jsp">Login</a></li>
        <li role="presentation"><a href="registration.jsp">Registration</a></li>
     </ul>
	
		<div class="row" style="margin-top:40px">
			<div class="col-md-6 col-md-offset-3">
				<form action="checkLogin">
					<div class="form-group">
						<label>Email address</label> <input type="text"
							class="form-control" name="email" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password" placeholder="Password">
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>	
</body>
</html>