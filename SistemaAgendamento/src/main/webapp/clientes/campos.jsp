<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="br.ufscar.dc.dsw.dao.ClientesDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table border="1">
	
	<caption>
		<%
		if (cliente != null) {%>
			<form action="atualizacao" method="post">
				<%@include file="campos.jsp"%>
			</form>
			<%} else { %>
				<form action="insercao" method="post">
					<%@include file="campos.jsp"%>
				</form>
			<%} %>
	</caption>
	
	<%if (cliente != null) { %>

		<input type="hidden" name="id" value="${cliente.id}" />
	<%} %>

	<tr>
		<td><label for="cpf">CPF</label></td>
		<td><input type="text" id="cpf" name="cpf" size="11" required
			value="${cliente.cpf}" /></td>
	</tr>
	<tr>
		<td><label for="email">E-mail</label></td>
		<td><input type="text" id="email" name="email" size="128"
			required value="${cliente.email}" /></td>
	</tr>

	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="password" id="senha" name="senha" size="64"
			required value="${cliente.senha}" /></td>
	</tr>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="128" required
			value="${cliente.nome}" /></td>
	</tr>
	<tr>
		<td><label for="telefone">Telefone</label></td>
		<td><input type="number" id="telefone" name="telefone" size="13"
			required value="${cliente.telefone}" /></td>
	</tr>
	<tr>
		<td><label for="sexo">Sexo</label></td>
		<td><input type="text" id="sexo" name="sexo" required size="2"
			value="${cliente.sexo}" /></td>
	</tr>
	<tr>
		<td><label for="nascimento">Data de nascimento</label></td>
		<td><input type="date" id="nascimento" name="nascimento" required
			value="${cliente.nascimento}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>