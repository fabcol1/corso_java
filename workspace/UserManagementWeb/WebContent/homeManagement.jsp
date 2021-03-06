<%@page import="org.entities.User"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="sun.font.Script"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.db.UserDBManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title> Users Management </title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="css/userManStyle.css">




<script>

    function getImgPath (currentUser) {
    	
    	
    	var defaultImg = "images/default_image.jpg";
    	
    	
    	if (currentUser.imgpath != undefined) {
    		
    		defaultImg = currentUser.imgpath;
    		
    	}
    	
    	console.log (currentUser.imgpath);
    	
    	return defaultImg;
    	
    	
   }


    var users = null ;
    
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
//     	        users=JSON.parse("'"+myRequest.responseText+"'");
     	        users=JSON.parse(myRequest.responseText);
    	        console.log("users: " + users);
    	        initializeView () ;
    	    }
    	    
    	}
    	myRequest.send();
    	
    }

    	function initializeView () {
    	 	console.log("INITIALIZE VIEW");
    		if (users!=null) {
    	        var usersSize = users.length;
   	         console.log("usersSize: " + usersSize);
    	        if (usersSize>0) {
    	        	
    	        	dynamicDiv= "<div class='container bootstrap snippet'>"+
    	        	            "<div align='center'>"+
    	                        "<div class='row'>"+
    	                        "<div class='col-lg-12'>"+
    	                     "<div class='main-box no-header clearfix'>"+
    	                            "<div class='main-box-body clearfix'>"+
    	                            "<div class='table-responsive'>"+
    	                            "<div style= 'overflow-x:auto; overflow y: auto'>"+
    	                            "<table class='table user-list'>"+
    	                            "<thead>"+
    	                                         "<tr>"+
    	                                         "<th width= 40%><div align='center'><span>User</span></div></th>"+
    	                                         "<th width= 20%><div align='center'><span>Created</span></div></th>"+
    	                                         "<th width= 40%><div align='center'><span>Email</span></div></th>"+
    	                                       
    	                                         "</tr>"+
    	                                     "</thead>"+
    	                                     "<tbody>"+
    	                                         "<tr>";
    			                                
    	      for (var i=0;i<usersSize; i++) {
    	        		
    	        		dynamicDiv = dynamicDiv +  "<td><img class= 'avatar' src='"+ getImgPath(users[i]) + "'style='width:100'>"+
                        "<class='user-link'><a href='mailto:"+ users[i].email +"' class='user-link'>"+ users[i].firstname +"</a>"+
                        "<div class='dropdown'><a href='#' data-toggle='dropdown' class='dropdown-toggle' id= 'icon'><b class='caret'></b></a>"+
                        "<ul class='dropdown-menu'><li><a href='mailto:"+ users[i].email +"'>Invia e-mail</a></li><li><a href='userDetails.jsp?button=" + users[i].id + "'>Edit User</a></li></ul></div>"+    
                        "<td>"+ users[i].regdate +"</td>"+
                        "<td><a href= 'mailto: "+ users[i].email +"'>"+ users[i].email +"</a></td>"+
                        "<td><form action= 'userDetails.jsp' method ='post'><Button type = 'submit' class = 'qualityButton' name = 'button' value ='"+ users[i].id +"'>Edit </Button></form></td></tr>";                              
                          
    		        }
    	        	
    	        	dynamicDiv = dynamicDiv + "</tbody></table></div></div></div></div></div></div></div></div>";
    	        	
    	        }
   
    	        
//     	         console.log(dynamicDiv);
    	        document.getElementById("content").innerHTML = dynamicDiv;
    	        
    	    }
    	}


 


</script>



</head>


<body onload = "executeListRequest();" >

<%@ include file="topBar.jsp" %>  <%--  includo topBar da un altro JSP --%>

 	<div id = "content">
 	</div>

   
</body>
</html>
    	     
  