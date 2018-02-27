<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/survey.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	var survey;

	function loadContent() {
		


	}

	function stampaProva() {
		var id = document.getElementById("quesID").value;
		var aVal = getCheckedBoxes(document.getElementById("quesID").value);
// 		aVal = document.getElementById("5").checked ;
		
		console.log(aVal);
// 		console.log(document.getElementById("lista"));
	}

	function getCheckedBoxes(id) {
		  var checkboxes = document.getElementsByName(id);
		  var checkboxesChecked = [];
		  // loop over them all
		  for (var i=0; i<checkboxes.length; i++) {
		     // And stick the checked ones onto an array...
		     if (checkboxes[i].checked) {
		        checkboxesChecked.push(checkboxes[i].value);
		     }
		  }
		  // Return the array if it is non-empty, or null
		  return checkboxesChecked.length > 0 ? checkboxesChecked : null;
		}

	function executeListRequest () {
		console.log("called executeListRequest");
		//1. create a new XMLHttpRequest object -- an object like any other!
		var myRequest = new XMLHttpRequest();
		// 2. open the request and pass the HTTP method name and the resource as parameters
		myRequest.open('GET', 'ListServlet');
		// 3. write a function that runs anytime the state of the AJAX request changes
		myRequest.onreadystatechange = function () { 
		    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
		    if (myRequest.readyState === 4) {
		        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
		        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
		        //
		        console.log(myRequest.responseText)
//	 	        users=JSON.parse("'"+myRequest.responseText+"'");
		        survey=JSON.parse(myRequest.responseText);
// 		        console.log("users: " + survey);
		        initializeView () ;
		    }
		    
		};
		myRequest.send();
		
	}
</script>
<title>Survey</title>
</head>
<body onload="loadContent()">
<h2>Choose the correct answer(s)!</h2>
<ul id="lista">
<li> Ciaoneeee
<li> ciao
</ul>
	
<form  id="formDomanda" onsubmit="stampaProva()">



        <h3 id="5">Which of the following Java operators can be used with boolean variables? (Choose all that apply)</h3><br>
        <label class="container"><input type="checkbox" value="AnsA" name="5" id="AnsA"><span class="checkmark"></span>   == </label><br><br>
        <label class="container"><input type="checkbox" value="AnsB" name="5" id="AnsB"><span class="checkmark"></span>   + </label><br><br>
        <label class="container"><input type="checkbox" value="AnsC" name="5" id="AnsC"><span class="checkmark"></span>   -- </label><br><br>
        <label class="container"><input type="checkbox" value="AnsD" name="5" id="AnsD"><span class="checkmark"></span>   ! </label><br><br>
		<label class="container"><input type="checkbox" value="AnsE" name="5" id="AnsE"><span class="checkmark"></span>   % </label><br><br>
		<label class="container"><input type="checkbox" value="AnsF" name="5" id="AnsF"><span class="checkmark"></span>   &lt;= </label><br><br>
		<input type="hidden" id="quesID" name="quesID" value="5">
		<input type="hidden" id="index" name="index" value="1">
		<input type="hidden" id="questionnaireID" name="questionnaireID" value="15">
		<input id="confirmB" type="submit" name="submitButt" value=" Finish ">

</form>

</body>
</html>