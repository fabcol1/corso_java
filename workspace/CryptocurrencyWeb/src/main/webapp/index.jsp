<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bitcoin - RealTime</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<script type="text/javascript" src="https://github.com/nagix/chartjs-plugin-streaming/releases/download/v1.1.0/chartjs-plugin-streaming.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pusher/4.1.0/pusher.js"></script>	
<script src="script/realTime/initBTCRealTimeChart.js"></script>
<script src="script/realTime/bitcoinRealTime.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>	
<body>
	<div class="container">
		<canvas id="Bitcoin"></canvas>
	</div>
	<script>
	bitcoinRealTime();
	</script>
</body>
</html>
