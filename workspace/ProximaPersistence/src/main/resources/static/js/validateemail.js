$(document).ready(function() {
//  $(document).on("click", function() {
	$("[name=email]").focusout( function() {
    console.log("sono dentro il campo mail");
    console.log($("[name=email]").val());
    if ($("[name=email]").val() != "") {

      //entro nel ciclo, i dati alla servlet li mandiamo con un json.
    	//dininisco una variabile che contiene la stringa JSON
			//faccio la chiamata ajax in cui specifico il type, url che conterrà il nome della nomeServlet
			//la stringa dati e uno stato di success o error

      //var dati = "{'email':'" + $("[name=email]").val() + "'}";
			var dati = "email="+ $("[name=email]").val();
      console.log(dati);
      $.ajax({
        type: "GET",
        url: "CheckEmail",
        data: dati,
        success: function(risposta) {
          var rispostaJSON = JSON.parse(risposta);
					if (rispostaJSON.code == 'KO') {
            console.log(rispostaJSON.code);
						$("#erremail").html(rispostaJSON.message);
						$("#erremail").css("color", rispostaJSON.properties.cssColor ).css("display", "block");
						$("#erremail").fadeOut(3000);
					}

        },
        error: function() {
          alert("Chiamata fallita, si prega di riprovare...");
        }
      });


    }

  });

});
