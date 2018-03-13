var pass = document.getElementById('pass1');
		var passrep = document.getElementById('pass2');
		pass.addEventListener("input", validationpsw);
		passrep.addEventListener("input", validationpsw);

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