<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Recovery AJAX</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">
		<div id="content"></div>
		
		<div class="row">
			<div class="col-xs-2" style="margin-top: 20px">
				<div class="btn-group-vertical">
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#recoveryModal">Recovery Password</button>
					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#resetModal">Reset
						Password</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="recoveryModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Recovery Password</h4>
				</div>

				<div class="modal-body">

					<label>Email address</label> <input type="text"
						class="form-control" id="email" placeholder="Enter email" required>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal"
						onclick="recoveryPassword()">Send</button>
				</div>

			</div>
		</div>
	</div>
	
	<div class="modal fade" id="resetModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Reset Password</h4>
				</div>

				<div class="modal-body">

					<label>Vecchia password</label> <input type="password"
						class="form-control" id="oldPass" placeholder="Enter old password" required>
					<label>Nuova password</label> <input type="password"
						class="form-control" id="newPass" placeholder="Enter new password" required>
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal"
						onclick="resetPassword()">Send</button>
				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">
	function recoveryPassword() {
		var emailVal = [];
		emailVal[0] = document.getElementById("email").value;

		if(emailVal != null && emailVal.length > 0) {
			var myRequest = new XMLHttpRequest();
			
			myRequest.open('POST', '/UserManagementWeb/PasswordRecoveryAJAX');
			myRequest.onreadystatechange = function () { 
				var res;
				var s;
			    if (myRequest.readyState === 4) {
// 			        console.log(myRequest.responseText)
			        res=JSON.parse(myRequest.responseText);
			       	if(res.value[0] === "ok") {
			       		s = 
						'<div class="alert alert-success alert-dismissable">'+
						'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'
			           + '<p>Complimenti! la tua richiesta ha avuto successo.</p><p>Hai ricevuto una email per generare la nuova password.</p></div>'
			       		document.getElementById("content").innerHTML = s;
// 			           '<div class="alert alert-success alert-dismissible fade in">BRAVOOOOO</div>';
			       	} else {
			       		s = 
						'<div class="alert alert-danger alert-dismissable">'+
						'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'
			           + 'Attenzione! ci sono stati problemi con la tua richiesta.</div>'
			       		document.getElementById("content").innerHTML = s;
			       	}
			    }
			};
			myRequest.send(JSON.stringify({value: emailVal}));
			
		} else {
			s = 
				'<div class="alert alert-danger alert-dismissable">'+
				'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'
	           + 'Attenzione! ci sono stati problemi con la tua richiesta.</div>'
	       		document.getElementById("content").innerHTML = s;
		}
			
	}
	
	function resetPassword() {
		var oldPass = document.getElementById("oldPass").value;
		var newPass = document.getElementById("newPass").value;
		
		console.log(oldPass + " " + newPass);
		if(oldPass != null && newPass != null && oldPass.length > 0 &&  newPass.length > 0) {
			var myRequest = new XMLHttpRequest();
			
			myRequest.open('POST', '/UserManagementWeb/PasswordResetAJAX');
			myRequest.onreadystatechange = function () { 
				var res;
				var s;
			    if (myRequest.readyState === 4) {
// 			        console.log(myRequest.responseText)
			        res=JSON.parse(myRequest.responseText);
			       	if(res.value[0] === "ok") {
			       		s = 
						'<div class="alert alert-success alert-dismissable">'+
						'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'
			           + '<p>Complimenti! la tua richiesta ha avuto successo.</p><p>Hai ricevuto una email contenente la nuova password.</p></div>'
			       		document.getElementById("content").innerHTML = s;
// 			           '<div class="alert alert-success alert-dismissible fade in">BRAVOOOOO</div>';
			       	} else {
			       		s = 
						'<div class="alert alert-danger alert-dismissable">'+
						'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'
			           + 'Attenzione! ci sono stati problemi con la tua richiesta.</div>'
			       		document.getElementById("content").innerHTML = s;
			       	}
			    }
			};
			
			var oldAndNewPassword = [oldPass, newPass];
			myRequest.send(JSON.stringify({value: oldAndNewPassword}));
		} else {
			s = 
				'<div class="alert alert-danger alert-dismissable">'+
				'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'
	           + 'Attenzione! ci sono stati problemi con la tua richiesta.</div>'
	       		document.getElementById("content").innerHTML = s;
		}
	}

</script>
</html>