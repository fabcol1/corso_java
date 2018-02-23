<%@page import="org.db.UserDBManager"%>
<%@page import="org.bean.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>USER SELECTION</title>

<link rel="stylesheet" type="text/css">

<%


 List <User> users = UserDBManager.getUsers();



%>


</head>

<link rel="stylesheet" type="text/css" href="css/userManStyle.css">

<hr>
<div class="container bootstrap snippet">


<div align="center">
    <div class="row">
        <div class="col-lg-12">
        
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                    <div style="overflow-x:auto; overflow-y: auto;">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th width= 40%><span>User</span></th>
                                <th width= 20%><span>Created</span></th>
                                <th width= 40%><span>Email</span></th>
                               
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                
                                  
                        <%         for (int i = 0; i < users.size(); i++) {
                        	
                        	
                        	
                        out.print ("<form action= 'userDetails.jsp'><td><img src='./default_image.jpg' style='width:100'> <class='user-link'><a href='mailto:"+users.get(i).getEmail()+"' class='user-link'>"+users.get(i).getFirstname()+"</a>");
                        out.print ("<td>"+users.get(i).getRegdate()+"</td>");	
                        out.print ("<td><a href= 'mailto: "+users.get(i).getEmail()+"'>"+users.get(i).getEmail()+"</a></td>");           
                        out.print ("<td><Button type = 'submit' class = 'qualityButton' name = 'button' value = '"+users.get(i).getId()+"'>Edit </Button></td></a>");      
                        out.print ("</tr></form> ");            
                                   
                                       
                        }                   
                   %>                                            
                                   
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
</div>
</html>