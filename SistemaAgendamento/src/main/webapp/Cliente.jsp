<%@page import="java.time.LocalDateTime"%>
<%@page import="br.ufscar.dc.dsw.dao.ClientesDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Profissionais"%>
<%@page import="br.ufscar.dc.dsw.dao.ProfissionaisDAO"%>
<%@page import="br.ufscar.dc.dsw.dao.ConsultasDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Consultas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.domain.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    Clientes cliente = (Clientes) request.getSession().getAttribute("cliente");
    if(cliente == null){
        response.sendRedirect("login");
        return;
    }
    ConsultasDAO consultaDAO = new ConsultasDAO();
    ProfissionaisDAO profissionalDAO = new ProfissionaisDAO();
    ArrayList<Consultas> consultas = consultaDAO.getbyCliente(cliente.getId());
    ArrayList<Profissionais> profissionais = profissionalDAO.getAll();
%>


<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Page</title>
    </head>
    <body>
        <h1>Olá, <%= cliente.getNome() %>!</h1>
        <a href="index.jsp">Log out</a>
        
        <h3>Seus Agendamentos</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Nome do profissional</th>
                    <th>Area de atuação</th>
                    <th>Especialidade</th>
                    <th>Data</th>
                </tr>
            </thead>
            <tbody>
                <% for (Consultas consulta : consultas) { %>
                    <tr>
                        <td><%= consulta.getNome_P() %></td>
                        <td><%= consulta.getArea() %></td>
                        <td><%= consulta.getEspecialidade() %></td>
                        <td><%= consulta.getData()%></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
            
        <h3>Marcar novo agendamento</h3>
        <form action="consulta/criar" method="post">
            <input type="hidden" value="<%= cliente.getId() %>" name="cliente" />
            <label>Profissionais:</label>
            <select name="profissional">
                <% for (Profissionais p : profissionais) { %>
                <option
                    value="<%= p.getId() %>">
                    <%= p.getNome() %>
                    -
                    <%= p.getArea() %>
                    -
                    <%= p.getEspecialidade() %>
                </option>
                <%}%>
            </select><br>
            <label>Data:</label><br>
            <label>Dia:</label>
            <input name="dia" value="" type="number" min="1" max="31"/>
            <label>Mes:</label>
            <input name="mes" value="" type="number" min="1" max="12"/>
            <label>Ano:</label>
            <input name="ano" value="" type="number"
            min="<%= LocalDateTime.now().getYear() %>"/>
            <label>Hora:</label>
            <input name="hora" value="" type="number" min="7" max="18"/>   
            <br>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
</fmt:bundle>