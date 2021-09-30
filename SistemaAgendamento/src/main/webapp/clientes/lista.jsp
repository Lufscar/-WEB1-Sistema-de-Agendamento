<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="br.ufscar.dc.dsw.dao.ClientesDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Clientes"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Clientes</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Gerenciamento de Clientes</h1>
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/Ctlcliente/cadastro">Adicione Novo Cliente</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Clientes</caption>
			<tr>
				<th>ID</th>
				<th>CPF</th>
				<th>E-mail</th>
				<th>Senha</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Sexo</th>
				<th>Data de Nascimento</th>
				<th>Ações</th>
				
			</tr>
			
			<%
			List(Clientes) clientes = (List) request.getSession().getAttribute("listaClientes");
			for (Clientes cliente: cliente) {%>
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.email}</td>
					<td>${cliente.senha}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.telefone}</td>
					<td>${cliente.sexo}</td>
					<td>${cliente.nascimento}</td>
					<td><a href="/<%= contextPath%>/Ctlcliente/edicao?id=${cliente.id}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/Ctlcliente/remocao?id=${cliente.id}"
						onclick="return confirm('Tem certeza de que deseja excluir este cliente?');">
							Remoção </a></td>
				</tr>
			<%} %>
			
		</table>
	</div>
</body>
</html>