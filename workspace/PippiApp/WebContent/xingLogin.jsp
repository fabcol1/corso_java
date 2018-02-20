<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

<script>
//     This function is called by the plugin after
//     the login flow is completed.

    function onXingAuthLogin(response) {
      var output;
 
      console.log(response);
 
      if (response.user) {
        output = 'Successful login for ' + response.user.display_name;
        
        logged = true;
      } else if (response.error) {
        output = 'Error: ' + response.error;
      }
 
      document.getElementById('output').innerHTML = output;
    }
    
    function tryLogout() {
    	console.log("ciao");
    	if(xing) {
        	xing.logout();
    	}
    }
  </script>
  
</head>
<body>

<script type="xing/login">
{
  "consumer_key": "09b341b73144f7b0a2af"
}
</script>
   
   <p id="output">No user logged in.</p>
 
 	<p>
 		<a href="" onclick="tryLogout();">
 		LOGOUT...
 		</a>
 	</p>
<script>(function(d) {
  var js, id='lwx';
  if (d.getElementById(id)) return;
  js = d.createElement('script'); js.id = id; js.src = "https://www.xing-share.com/plugins/login.js";
  d.getElementsByTagName('head')[0].appendChild(js)
}(document));</script>

</body>
</html>