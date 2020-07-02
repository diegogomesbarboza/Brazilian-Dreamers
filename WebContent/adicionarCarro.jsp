<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de carro</title>
<meta charset="ISO-8859-1">
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
	<div class="container-fluid" style="background: black;">
		<%@ include file="menuLogin.jsp"%>

		<div class="row d-flex justify-content-center">
			<div class="col-md-6">
				<h3>Incluir/Alterar Carro</h3>
				<div class="jumbotron" style="opacity: 0.7">
					<div class="col-md-12">
						<c:if test="${not empty mensagem}">
							<div class="alert alert-danger" role="alert">
								<p>${mensagem}</p>
							</div>
						</c:if>
						<form role="form" action="CarroServlet" method="get">
							<input name="acao" type="hidden" value="salvar"> <input
								name="id_carro" type="hidden" value="${carro.idCarro}" />
							<div class="form-group col-md-6">
								<label for="fabricante"> Fabricante </label> <input
									id="fabricante" name="fabricante" class="form-control"
									value="${carro.fabricante}" required>
							</div>
							<div class="form-group col-md-6">
								<label for="modelo"> Modelo </label> <input id="modelo"
									name="modelo" class="form-control" value="${carro.modelo}"
									required>
							</div>
							<div class="form-group col-md-6">
								<label for="ano"> Ano </label> <input id="ano" name="ano"
									class="form-control" value="${carro.ano}" required>
							</div>
							<div class="form-group col-md-6">
								<label for="potencia"> Potencia </label> <input id="potencia"
									name="potencia" class="form-control" value="${carro.potencia}"
									required>
							</div>
							<div class="form-group col-md-6">
								<label for="peso"> Peso </label> <input id="peso" name="peso"
									class="form-control" value="${carro.peso}" required>
							</div>
							<div class="form-group col-md-12">
								<label for="uppgrade_interno">Upgrades</label> <input
									id="uppgrade_interno" name="uppgrade_interno"
									class="form-control" value="${carro.uppgrade_interno}" required>
							</div>
							<div class="form-group col-md-12">
								<label for="estetica_externo">Esteticas</label> <input
									id="estetica_externo" name="estetica_externo"
									class="form-control" value="${carro.estetica_externo}" required>
							</div>
							<div class="form-group col-md-6">
								<label for="imagem"> Imagem </label>
								<input id="imagem" name="imagem" type="file" value="${carro.imagem}"/>
							</div>
							<div class="form-group col-md-6">
								<button type="button" class="btn btn-default"
									onclick="window.location.href='/Brazilian-Dreamers/CarroServlet?acao=listar'">
									Cancelar</button>
								<button type="submit" class="btn btn-primary">Salvar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-12" style="height: 5rem;"></div>
		<%@ include file="rodape.jsp"%>

	</div>

	<!--  rodapé do body -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>