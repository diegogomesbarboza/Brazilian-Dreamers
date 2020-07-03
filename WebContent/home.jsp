<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Locadora de Veículos</title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container-fluid" style="background: black;">
		<%@ include file="menu.jsp"%>

		<div class="row">
			<div class="col-md-4">&nbsp;</div>

			<div class="col-md-4">
				<div class="jumbotron" style="opacity: 0.7">
					<h1>Nosso dia a dia</h1>
					<p>Conheça os melhores carros e desejados de Brasilia e venha
						sonhar conosco esse sonho!</p>
					<img alt="Locadora" src="imagens/teste2.png">

				</div>
			</div>
		</div>
	
			<%@ include file="rodape.jsp"%>
		</div>

		<!--  rodapé do body -->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/scripts.js"></script>
</body>
</html>
