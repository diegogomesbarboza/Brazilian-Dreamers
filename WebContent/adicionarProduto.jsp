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
				<h3>Incluir/Alterar Produto</h3>
				<div class="jumbotron" style="opacity: 0.7">
					<div class="col-md-12">
						<c:if test="${not empty mensagem}">
							<div class="alert alert-danger" role="alert">
								<p>${mensagem}</p>
							</div>
						</c:if>
						<form role="form" action="servlet">
							<input name="acao" type="hidden" value="salvar">
							<input name="id_produto" type="hidden" value="${produto.id_produto}">
							<div class="form-group col-md-6">
								<label for="nome_produto"> Produto </label> <input id="nome_produto"
									name="nome_produto" class="form-control"
									value="${produto.nome_produto}" required>
							</div>
							<div class="form-group col-md-12">
								<label for="valor_produto">Preço</label> <input
									id="valor_produto" name="valor_produto" class="form-control"
									type="number" value="${produto.valor_produto}" required>
							</div>
							<div class="form-group col-md-6">
								<label for="imagem_produto"> Imagem </label>
								<input
									id="imagem_produto" name="imagem_produto" class="form-control"
									 value="${produto.imagem_produto}" placeholder="Insira uma URL: http://exemplo.com.br" required>
							</div>
							<div class="form-group col-md-6">
								<button type="button" class="btn btn-default"
									onclick="window.location.href='/Brazilian-Dreamers/homeLogin.jsp'">
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