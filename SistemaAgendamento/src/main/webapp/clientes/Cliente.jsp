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
        <h1><fmt:message key="welcome"/> <%= cliente.getNome() %></h1>
        <a href="logout">Log out</a>
        
        <h3><fmt:message key="your_appointments"/></h3>
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
            
        <h3><fmt:message key="set_appointment"/></h3>
        <form action="consulta/create" method="post">
            <input type="hidden" value="<%= cliente.getId() %>" name="paciente" />
            <label><fmt:message key="field_medico"/>:</label>
            <select name="medico">
                <% for (Profissionais p : profissionais) { %>
                <option
                    value="<%= p.getId() %>">
                    <%= p.getNome() %>
                    -
                    <fmt:message key="<%= p.getArea() %>"/>
                </option>
                <%}%>
            </select><br>
            <label><fmt:message key="field_date_time"/>:</label><br>
            <label><fmt:message key="field_day"/>:</label>
            <input name="dia" value="" type="number" min="1" max="31"/>
            <label><fmt:message key="field_month"/>:</label>
            <input name="mes" value="" type="number" min="1" max="12"/>
            <label><fmt:message key="field_year"/>:</label>
            <input name="ano" value="" type="number"
            min="<%= LocalDateTime.now().getYear() %>"/>
            <label><fmt:message key="field_hour"/>:</label>
            <input name="hora" value="" type="number" min="7" max="18"/>
            <label><fmt:message key="field_minute"/>:</label>
            <select name="minuto">
                <option value="0">00</option>
                <option value="30">30</option>
            </select>
            <br>
            <input type="submit" value="<fmt:message key="submit"/>" />
        </form>
        
    </body>
</html>
</fmt:bundle>