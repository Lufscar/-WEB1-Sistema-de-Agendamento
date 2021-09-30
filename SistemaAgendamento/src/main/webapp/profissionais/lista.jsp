<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="br.ufscar.dc.dsw.dao.ProfissionaisDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Profissionais"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Profissionais</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Gerenciamento de Profissionais</h1>
		<h2>
			<a href="index.jsp">Menu Principal</a> &nbsp;&nbsp;&nbsp; 
			<a href="/Ctlprofissional/cadastro">Adicione Novo Profissional</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Profissionais</caption>
			<tr>
				<th>ID</th>
				<th>CPF</th>
				<th>E-mail</th>
				<th>Senha</th>
				<th>Nome</th>
				<th>Area</th>
				<th>Sexo</th>
				<th>Especialidade</th>
				<th>Ações</th>
				
			</tr>
			
			<%
			ArrayList<Profissionais> profissionais = (ArrayList<Profissionais>) request.getSession().getAttribute("listaProfissionais");
			for (Profissionais profissional: profissionais) {%>
				<tr>
					<td>${profissional.id}</td>
					<td>${profissional.cpf}</td>
					<td>${profissional.email}</td>
					<td>${profissional.senha}</td>
					<td>${profissional.nome}</td>
					<td>${profissional.telefone}</td>
					<td>${profissional.sexo}</td>
					<td>${profissional.nascimento}</td>
					<td><a href="/<%= contextPath%>/Ctlprofissional/edicao?id=${profissional.id}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/Ctlprofissional/remocao?id=${profissional.id}"
						onclick="return confirm('Tem certeza de que deseja excluir este profissional?');">
							Remoção </a></td>
				</tr>
			<%} %>
			
		</table>
	</div>
</body>
</html>