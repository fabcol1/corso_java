<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LUCA CHAT</title>
<link rel="stylesheet" type="text/css" href="NewFile.css" />
<style type="text/css">
</style>
<head>
<title>FORM JAVASCRIPT LOGIN</title>
<!-- Include CSS File Here -->
<link rel="stylesheet" href="css/submit_javascript.css" />
<!-- Include JS File Here -->
<script>
	//Submit form con la funzione id.
	function submit_by_id() {
		var nome = document.getElementById("nomeutente").value;
		var pass = document.getElementById("password").value;

		console.log(nome + pass);

		if (validation()) // Calling validation function
		{

			alert(" Nome Utente : " + nome + " \n Password : " + pass
					+ " \n FORM : "
					+ document.getElementById("form_id").getAttribute("id")
					+ "\n\n I CAMPI INSERITI SONO IN CORSO DI VALIDAZIONE... PER FAVORE ATTENDI.");

			document.getElementById("form_id").submit();
			
		}

	}

	//Funzione di Validazione Email e Password
	function validation() {

		var nome = document.getElementById("nomeutente").value;
		var pass = document.getElementById("password").value;

		if (nomeutente == '' || pass == '') {
			alert("I CAMPI NON SONO RIEMPITI CORRETTAMENTE. RIEMPI TUTTI I CAMPI.");
			return false;
		} else if (nome.length > 50 || pass.length > 50) {
			
			alert("PASSWORD TROPPO LUNGA");
			return false;
		} else {	
			return true;		
		}	
	}
</script>
</head>
<body>
	<form action="check.jsp" method="post" name="form_name" id="form_id"
		class="form_class">
		<h2>PAGINA DI LOGIN</h2>
		<label>Email :</label> <input type="text" name="nomeutente"
			id="nomeutente" placeholder="mail@provider.dominio" /> <label>Password
			:</label> <input type="text" name="password" id="password"
			placeholder="pAssw0rd" /> <input type="button" name="submit_id"
			id="btn_id" value="LOGIN" onclick="submit_by_id()" />
	</form>
-----------------------------------------------------------------------------------------------------------------------------
	<form action="pagina_registrazione.html" method="post"
		name="form_registrazione" id="form_registrazione"
		class="registrazione">
		<input type="submit" name="registrazione" id="registrazione"
			value="REGISTRATI" />
	</form>
</body>
</html>
