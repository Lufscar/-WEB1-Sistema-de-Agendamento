<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.domain.Profissionais"%>
<%@page import="br.ufscar.dc.dsw.dao.ProfissionaisDAO"%>
<%
	ProfissionaisDAO daoprofissionais = new ProfissionaisDAO();
ArrayList<Profissionais> profissionais = null;
String area = request.getParameter("a");
if (area != null) {
	profissionais = daoprofissionais.getbyArea(area);
} else {
	profissionais = daoprofissionais.getAll();
}
%>


<!DOCTYPE html>
<fmt:bundle basename="messages">
	<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="content-language" content="lat" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="description"
	content="Sistema para agendamento de consultas online comprofissionais" />
<meta name="keywords" content="Lorem, ipsum, dolor, sit">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1, maximum-scale=1, user-scalable=no" />
<style type="text/css"> @import url("Estilo.css"); </style>
</head>
<body>


	<header class="containerHeader">

		<nav>

			<input type="checkbox" id="check"> <label for="check"
				class="checkbtn"> <i class="fas fa-bars"></i>
			</label>


			<ul>
				<li><a class="active"
					href="http://localhost:8080/SistemaAgendamento/">Início</a></li>

				<li><a href="login.jsp">Login</a></li>
			</ul>
		</nav>
		<section></section>
	</header>

	<section class="cover">
		<div class="top_cover">
			</h1>
		</div>
		<div class="top_cover">
			<h1>
				<a href="login.jsp">Bem Vindo! Entre na sua conta</a><br>
				<br>
			</h1>
		</div>
		<div class="top_cover">
			<h2>
				Confira nossa lista de profissionais
				<%
				if (area != null) {
			%>
				em
				<%=area%>
				<%
					}
				%>
			</h2>

			<div style="overflow-x: auto;">
				<table>
					<thead>
						
							<th>CPF</th>
							<th>Nome</th>
							<th>Area</th>
							<th>Especialidade</th>
							<th>Email</th>
						
					</thead>
					<tbody>
						<%
							for (Profissionais profissional : profissionais) {
						%>
						<tr>
							<td><%=profissional.getCpf()%></td>
							<td><%=profissional.getNome()%></td>
							<td><%=profissional.getArea()%></td>
							<td><%=profissional.getEspecialidade()%></td>
							<td><%=profissional.getEmail()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<br> Selecione a area:
			<form action="" method="POST">
				<input type="text" id="a" name="a" size="20"> <input
					type="submit" value="Pesquisar" />
			</form>

		</div>








	</section>

	<main id="#">
		<p>
			<a>Nesta área,</a> você pode realizar uma busca por médico a partir
			do preenchimento dos campos
		</p>
		</br>
		<p>Quanto maior o número de dados, mais fácil será encontrar o
			profissional que procura.</p>
	</main>

	<section class="container2x5">
		<div>
			<center>
				<h1>Consulta médica</h1>
			</center>
			</br>
			</br>
			<p>Sistema para agendamento de consultas online comprofissionais</p>
		</div>
		<div>
			<ul>
				<li>
					<div id="image_beside" class="_1">

						<h2>Consulta</h2>
						Sistema para agendamento de consultas online comprofissionais
						</p>
					</div>
				</li>
				<li>
					<div id="image_beside" class="_2">

						<h2>Edição</h2>
						Sistema para agendamento de consultas online comprofissionais
						</p>
					</div>
				</li>
				<li>
					<div id="image_beside" class="_3">

						<h2>Remoção</h2>
						Sistema para agendamento de consultas online comprofissionais
						</p>
					</div>
				</li>
				<li>
					<div id="image_beside" class="_4">

						<h2>Agendamento</h2>
						Sistema para agendamento de consultas online comprofissionais
						</p>
					</div>
				</li>
				<li>
					<div id="image_beside" class="_5">

						<h2>Profissionais</h2>
						Sistema para agendamento de consultas online comprofissionais
						</p>
					</div>
				</li>
				<li>
					<div id="image_beside" class="_6">

						<h2>Clientes</h2>
						Sistema para agendamento de consultas online comprofissionais
						</p>
					</div>
				</li>

			</ul>
		</div>
	</section>

</body>
	</html>
</fmt:bundle>