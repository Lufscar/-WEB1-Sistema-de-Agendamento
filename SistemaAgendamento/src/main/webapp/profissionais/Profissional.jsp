<%@page import="br.ufscar.dc.dsw.domain.Clientes"%>
<%@page import="br.ufscar.dc.dsw.domain.Consultas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.domain.Profissionais"%>
<%@page import="br.ufscar.dc.dsw.dao.ConsultasDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%  
    Profissionais profissional = (Profissionais) request.getSession().getAttribute("profissional");
    if(profissional == null){
        response.sendRedirect("login");
        return;
    }
    ConsultasDAO consultaDAO = new ConsultasDAO();
    ArrayList<Consultas> consultas = consultaDAO.getbyProfissional(profissional.getId());
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profissional Page</title>
    </head>
    <body>
        <h1><fmt:message key="welcome"/> <%= profissional.getNome() %></h1>
        <a href="logout">Log out</a>
        
        <h3><fmt:message key="your_appointments"/></h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Nome do cliente</th>
                    <th>Data da consulta</th>
                </tr>
            </thead>
            <tbody>
                <% for (Consultas consulta : consultas) { %>
                    <tr>
                        <td><%= consulta.getNome_C() %></td>
                        <td><%= consulta.getData()%></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>

</fmt:bundle>