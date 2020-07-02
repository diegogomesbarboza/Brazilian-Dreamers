<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Brazilian Dreamers</title>
<meta charset="utf-8" />
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
		<%@ include file="menu.jsp"%>

		<div class="row d-flex justify-content-center">
			<div class="col-md-8">
				<h3>Produtos Disponíveis</h3>
				
				<div class="row">
					<div class="col-md-12">
						<c:forEach var="produto" items="${lista}">
							<div class="card"
								style="width: 18rem; float: left; margin: 30px;">
								<img class="card-img-top" src="${produto.imagem_produto}"
									style="width: 285px; height: 250px;">
								<div class="card-body" style="display: flex;">
									<h5 class="card-title"
										style="color: black; font-family: Megrim, cursive;">${produto.nome_produto}</h5>
								</div>
								<ul class="list-group list-group-flush">
									<li class="list-group-item">Produto:
										${produto.nome_produto}</li>
									<li class="list-group-item">Valor:
										${produto.valor_produto}</li>
								</ul>
							</div>
						</c:forEach>
					</div>
				</div>

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