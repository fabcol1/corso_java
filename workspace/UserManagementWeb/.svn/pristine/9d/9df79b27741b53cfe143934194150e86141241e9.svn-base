<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHAT</title>
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

		console.log(nome);

		if (validation()) // Calling validation function
		{

			alert(" Email : " + nome 
					+ document.getElementById("form_id").getAttribute("id")
					+ "\n\n IL CAMPO INSERITI SONO IN CORSO DI VALIDAZIONE... PER FAVORE ATTENDI.");

			document.getElementById("form_id").submit();
			
		}

	}

	//Funzione di Validazione Email e Password
	function validation() {

		var nome = document.getElementById("nomeutente").value;

		if (nomeutente == '') {
			alert("DEVI RIEMPIRE IL CAMPO");
			return false;
		}  else if (nome.length > 30) {
			
			alert("EMAIL TROPPO LUNGA");
			return false;
		} else {	
			return true;		
		}	
	}
</script>
</head>
<body>

	LOGIN TRAMITE TOKEN:
	<form action="TestServletToken" method="post" name="form_name" id="form_id"
		class="form_class">
		<h3>INSERISCI L'EMAIL CON LA QUALE TI SEI REGISTRATO. TI INVIEREMO UN TOKEN NELLA TUA CASELLA DI POSTA ELETTRONICA.</h3>
		<label>Email per la richiesta di login:</label> <input type="text" name="nomeutente"
			id="nomeutente" placeholder="mail@provider.dominio" />
			<input type="button" name="submit_id"
			id="btn_id" value="INVIO TOKEN" onclick="submit_by_id()" />
	</form>

