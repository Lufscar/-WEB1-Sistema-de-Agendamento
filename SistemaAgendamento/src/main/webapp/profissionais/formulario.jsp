<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="br.ufscar.dc.dsw.dao.ProfissionaisDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Profissionais"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Profissionais</title>
</head>

<body>
	<div align="center">
		<h1>Gerenciamento de Profissionais</h1>
		<h2>
			<a href="lista">Lista de Profissionais</a>
		</h2>
	</div>
	<div align="center">
		<%
		Profissionais profissional = (Profissionais) request.getSession().getAttribute("profissional");
		if (profissional != null) {%>			
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