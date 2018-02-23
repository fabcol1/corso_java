<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>File Uploading Form</title>
</head>
<body>
<%
	session.setAttribute("email", session.getAttribute("email"));
%>
<form action="UploadServlet" method="Post"  enctype="multipart/form-data">

<table style='width:500px;  margin:auto'>
<tr>
<td> Select Photo  </td>
<td><input type="file" name="file" size="50" /></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Upload File" />
</td>
</tr>
</table>
</form>
</body>