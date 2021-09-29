<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${profissional != null}">
                               Edição
                           </c:when>
			<c:otherwise>
                               Cadastro
                           </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${profissional != null}">
		<input type="hidden" name="id" value="${profissional.id}" />
	</c:if>
	private Long id; 
	private String email; 
	private String senha; 
	private String cpf; 
	private String nome; 
	private String area; 
	private String especialidade;
	<tr>
		<td><label for="cpf">CPF</label></td>
		<td><input type="text" id="cpf" name="cpf" size="11" required
			value="${profissional.cpf}" /></td>
	</tr>
	<tr>
		<td><label for="email">E-mail</label></td>
		<td><input type="text" id="email" name="email" size="128"
			required value="${profissional.email}" /></td>
	</tr>

	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="password" id="senha" name="senha" size="64"
			required value="${profissional.senha}" /></td>
	</tr>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="128" required
			value="${profissional.nome}" /></td>
	</tr>
	<tr>
		<td><label for="telefone">Área</label></td>
		<td><input type="number" id="telefone" name="telefone" size="13"
			required value="${profissional.area}" /></td>
	</tr>
	<tr>
		<td><label for="sexo">Especialidade</label></td>
		<td><input type="text" id="sexo" name="sexo" required size="128"
			value="${profissional.especialidade}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>