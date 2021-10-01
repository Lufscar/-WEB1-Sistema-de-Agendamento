<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.domain.Profissionais"%>
<%@page import="br.ufscar.dc.dsw.dao.ProfissionaisDAO"%>
<%
    ProfissionaisDAO daoprofissionais = new ProfissionaisDAO();
    ArrayList<Profissionais> profissionais = null;
    String area = request.getParameter("a");
    if(area != null){
        profissionais = daoprofissionais.getbyArea(area);
    }
    else{
        profissionais = daoprofissionais.getAll();
    }
%>


<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <h1>blablabla</h1>
        <a href="login.jsp">Login</a><br><br>
        
        
        <h3>Profissionais
            <% if(area != null){%>  em
                <%= area %>
            <%}%>
        </h3>
        <table border="1">
            <thead>
                <tr>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th>Area</th>
                    <th>Especialidade</th>
                    <th>Email</th>
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
                    </tr>
                <%}%>
            </tbody>
        </table>
        <br>
        Selecione a area: 
        <form action="" method="POST">
        	<input type="text" id="a" name="a" size="20">
        	<input type="submit" value="Pesquisar" />
        </form>
        
    </body>
</html>
</fmt:bundle>