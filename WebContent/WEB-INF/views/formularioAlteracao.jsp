<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/empresa" var="linkEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formul�rio de altera��o de dados</title>
<link rel="stylesheet" href="static/css/empresas.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		Ol� ${usuario.login} bem vindo ao cadastro de empresas.
		<header>
			<c:import url="templateLogout.html" />
			<h1 class="titulo">Altera��o</h1>
		</header>
		<form action="${linkEmpresa}" method="POST">
			<input type="hidden" name="acao" value="AlteraEmpresa" />
			<div class="form-row">
				<div class="form-group col-md-4">
					<label>CNPJ da empresa</label> ${empresa.id} <input type="hidden"
						name="id" class="form-control" value="${empresa.id}" />
				</div>
				<div class="form-group col-md-4">
					<label>Nome da empresa</label> <input type="text" name="nome"
						class="form-control" value="${empresa.nome}" />
				</div>
				<div class="form-group col-md-4">
					<label>Data de abertura</label> <input type="text"
						name="dataAbertura" class="form-control"
						value="<fmt:formatDate value="${empresa.dataAbertura}"
								pattern="yyyy/MM/dd" />" />
				</div>
			</div>
			<input type="submit" value="Salvar Altera��es"
				class="btn btn-primary" />
		</form>
	</div>
</body>
</html>