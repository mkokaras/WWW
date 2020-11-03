<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Result</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<div class="container-contact100">
			 <div class="wrap-contact100">
			<%
			List styles = (List)request.getAttribute("styles");

			if(styles.isEmpty()){
				out.print("<h1>Product already exists in database</h1>");
				return;
			}
			out.print("<h3>Barcode:</h3>");
			out.print("<p>" + styles.get(0) + "</p>");

			out.print("<h3>Name:</h3>");
			out.print("<p>" + styles.get(1) + "</p>");

			out.print("<h3>Color:</h3>");
			out.print("<p>" + styles.get(2) + "</p>");

			out.print("<h3>Description:</h3>");

			out.print("<p>" + styles.get(3) + "</p>");

		 	%>

			</div>
	</div>
</body>
</html>