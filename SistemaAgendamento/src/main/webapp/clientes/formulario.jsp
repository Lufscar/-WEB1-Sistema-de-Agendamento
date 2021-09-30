<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="br.ufscar.dc.dsw.dao.ClientesDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<html>
<head>
<title>Clientes</title>
</head>

<body>
	<div align="center">
		<h1>Gerenciamento de Clientes</h1>
		<h2>
			<a href="lista">Lista de Clientes</a>
		</h2>
	</div>
	<div align="center">
		<%
		Clientes cliente = (Clientes) request.getSession().getAttribute("cliente");
		if (cliente != null) {%>
			
				<form action="atualizacao" method="post">
					<%@include file="campos.jsp"%>
				</form>
			<%} else { %>
				<form action="insercao" method="post">
					<%@include file="campos.jsp"%>
				</form>
			<%} %>
		
	</div>
</body>
</html>