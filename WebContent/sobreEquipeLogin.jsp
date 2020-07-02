<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Brazilian Dreamers</title>
<meta charset= "ISO-8859-1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid" style="color: white; background: black;">
		<%@ include file="menuLogin.jsp"%>

		<h3>Sobre os Carros</h3>
		<p>Conheça a equipe mais sonhadora dessa Brasilia</p>
		<div class="row">
			<div class="col-md-12">
				<c:forEach var="carro" items="${lista}">
					<div class="card" style="width: 18rem; float: left; margin: 30px;">
						<img class="card-img-top" src="${carro.imagem}"
							style="width: 285px; height: 250px;">
						<div class="card-body" style="display: flex;">
							<h5 class="card-title" style="color: black; font-family: Megrim, cursive;">${carro.modelo}</h5>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Fabricante: ${carro.fabricante}</li>
							<li class="list-group-item">Modelo: ${carro.modelo}</li>
							<li class="list-group-item">Ano: ${carro.ano}</li>
							<li class="list-group-item">Potencia: ${carro.potencia}CV</li>
							<li class="list-group-item">Peso: ${carro.peso}KG</li>
							<li class="list-group-item">Upgrades: ${carro.uppgrade_interno}</li>
							<li class="list-group-item">Estética: ${carro.estetica_externo}</li>
						</ul>
						<div class="card-body">
							<a
								href="/Brazilian-Dreamers/CarroServlet?acao=editar&id_carro=${carro.idCarro}">EDITAR</a>
							<a
								href="/Brazilian-Dreamers/CarroServlet?acao=excluir&id_carro=${carro.idCarro}">EXCLUIR
							</a>
						</div>
					</div>

				</c:forEach>
			</div>
		</div>

		<div class="col-md-12" style="height: 10rem;"></div>
		<%@ include file="rodape.jsp"%>
	</div>

	<!--  rodapé do body -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>