<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="br.ufscar.dc.dsw.dao.ClientesDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Clientes"%>
<%@page import="br.ufscar.dc.dsw.dao.ProfissionaisDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Profissionais"%>
<%@page import="java.util.ArrayList"%>
<%

	String tipo = (String) request.getSession().getAttribute("tipo");
	if (!tipo.equals("admin")) {
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);		
	}
	    ProfissionaisDAO daoprofissionais = new ProfissionaisDAO();
	    ArrayList<Profissionais> profissionais = daoprofissionais.getAll();
	    ClientesDAO daoclientes = new ClientesDAO();
	    ArrayList<Clientes> clientes = daoclientes.getAll();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Olá, Admin</h1>
        <a href="logout">Log out</a>
        <a href="Ctlcliente">link</a> crud cliente
        <a href="Ctlprofissional">link</a> crud profissional
        <h3>CRUD Profissionais</h3>
        <a href="Ctlcliente/cadastro">add</a>
        <table border="1">
            <thead>
                <tr>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th>Area</th>
                    <th>Especialidade</th>
                    <th>Email</th>
                    <th>ações</th>
                </tr>
            </thead>
            <tbody>
                <% for (Profissionais profissional : profissionais) { %>
                    <tr>
                   		<td><%= profissional.getCpf() %></td>
                        <td><%= profissional.getNome()%></td>
                        <td><%= profissional.getArea()%></td>
                        <td><%= profissional.getEspecialidade()%></td>
                        <td><%= profissional.getEmail()%></td>
                        <td>
                            <a href="Ctlprofissional/edicao?id=<%= profissional.getId() %>">Editar</a>
                            <a href="Ctlprofissional/delete?id=<%= profissional.getId() %>">Excluir</a>
                        </td>
                    </tr>
                <%}%>
            </tbody>
        </table>
            
        <h3>CRUD Clientes</h3>
        <a href="Ctlcliente/cadastro">add</a>
        <table border="1">
            <thead>
                <tr>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th>Sexo</th>
                    <th>Data de nascimento</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
            <% for (Clientes cliente : clientes) { %>
                <tr>
                    <td><%= cliente.getCpf()%></td>
                    <td><%= cliente.getNome()%></td>
                    <td><%= cliente.getSexo()%></td>
                    <td><%= cliente.getNascimento()%></td>
                    <td><%= cliente.getTelefone()%></td>
                    <td><%= cliente.getEmail()%></td>
                    <td>
                        <a href="Ctlcliente/edicao?id=<%= cliente.getId()%>">Editar</a>
                        <a href="Ctlcliente/remocao?id=<%= cliente.getId()%>">Deletar</a>
                    </td>
                </tr>
            <%}%>
            </tbody>
        </table>

    </body>
</html>
</fmt:bundle>