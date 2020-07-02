<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="ISO-8859-1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid" style="background: black;">

		<div class="row d-flex justify-content-center">
			<div class="col-md-6">
				<h3>Acesso</h3>
				<div class="jumbotron" style="opacity: 0.7">
					<div class="col-md-12">
						<c:if test="${not empty mensagem}">
							<div class="alert alert-danger" role="alert">
								<p>${mensagem}</p>
							</div>
						</c:if>
						<form role="form" action="UserServlet" method="post">
							<input name="acao" type="hidden" value="logar">
							<div class="form-group col-md-4">
								<label for="login">Usuario</label> <input id="login"
									name="login" class="form-control" type="text"
									value="${pessoa.login}">
							</div>
							<div class="form-group col-md-4">
								<label for="password">Senha</label> <input id="password"
									name="password" class="form-control" type="password"
									value="${pessoa.password}">
							</div>
							<div class="form-group col-md-4">
								<button type="submit" class="btn btn-primary">Entrar</button>
								<button type="button" class="btn btn-default"
									onclick="window.location.href='/Brazilian-Dreamers/home.jsp'">
									Cancelar</button>
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