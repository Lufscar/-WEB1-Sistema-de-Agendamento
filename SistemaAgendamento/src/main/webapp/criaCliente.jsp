<%@page import="br.ufscar.dc.dsw.domain.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    Clientes cliente = new Clientes();
%>

<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Patient Page</title>
    </head>
    <body>
        <h1><fmt:message key="add_patient_title"/></h1>
        <form action="Ctlcliente/insercao" method="POST">
            <table border="1">
				<tr>
					<td><label for="cpf">CPF</label></td>
					<td><input type="text" id="cpf" name="cpf" size="11" required
						value="" /></td>
				</tr>
				<tr>
					<td><label for="email">E-mail</label></td>
					<td><input type="text" id="email" name="email" size="128"
						required value="" /></td>
				</tr>
			
				<tr>
					<td><label for="senha">Senha</label></td>
					<td><input type="password" id="senha" name="senha" size="64"
						required value="" /></td>
				</tr>
				<tr>
					<td><label for="nome">Nome</label></td>
					<td><input type="text" id="nome" name="nome" size="128" required
						value="" /></td>
				</tr>
				<tr>
					<td><label for="telefone">Telefone</label></td>
					<td><input type="number" id="telefone" name="telefone" size="13"
						required value="" /></td>
				</tr>
				<tr>
					<td><label for="sexo">Sexo</label></td>
					<td><input type="text" id="sexo" name="sexo" required size="2"
						value="" /></td>
				</tr>
				<tr>
					<td><label for="nascimento">Data de nascimento</label></td>
					<td><input type="date" id="nascimento" name="nascimento" required
						value="" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
				</tr>
			</table>
        </form>
    </body>
</html>
</fmt:bundle>