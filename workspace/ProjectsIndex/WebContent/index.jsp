<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
Progetti:<br/>
<ul>
<jsp:include page="./mercurio/index.html"/> 
<jsp:include page="./fabcas/index.html"/>
<jsp:include page="./marco/index.html"/> 
<jsp:include page="./daniele_grizzi/index.html"/> 
<jsp:include page="./fabcol/index.html"/>
<jsp:include page="./lucatarqui/index.html"/> 
</ul>
<input type="button" class="btn btn-lg btn-default" value="ola"/>
<button type="button" class="btn btn-lg btn-default">Default</button>

</body>
</html>