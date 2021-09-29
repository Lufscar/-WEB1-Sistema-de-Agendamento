package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.dao.ClientesDAO;
import br.ufscar.dc.dsw.dao.ProfissionaisDAO;
import br.ufscar.dc.dsw.domain.Clientes;
import br.ufscar.dc.dsw.domain.Profissionais;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(name = "Index", urlPatterns = { "/index.jsp" })
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();
		if (request.getParameter("bOK") != null) {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String tipo = request.getParameter("tipo");
			
			if (login == null || login.isEmpty()) {
				erros.add("Login não informado!");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("Senha não informada!");
			}
			
			if (!erros.isExisteErros()) {
				
				if (tipo.equals("cliente")) {
					ClientesDAO dao = new ClientesDAO();
					Clientes usuario = dao.getbyLogin(login);
					if (usuario != null) {
						if (usuario.getSenha().equals(senha)) {
							request.getSession().setAttribute("cliente", usuario);
							response.sendRedirect("Cliente.jsp");
							return;
						} else {
							erros.add("Senha inválida!");
						}
					} else {
						erros.add("Usuário não encontrado!");
					}
					return;
				}
				
				if (tipo.equals("profissional")) {
					ProfissionaisDAO dao = new ProfissionaisDAO();
					Profissionais usuario = dao.getbyLogin(login);
					if (usuario != null) {
						if (usuario.getSenha().equals(senha)) {
							request.getSession().setAttribute("profissional", usuario);
							response.sendRedirect("Profissional.jsp");
							return;
						} else {
							erros.add("Senha inválida!"+usuario.getSenha()+usuario.getEmail()+senha);
						}
					} else {
						erros.add("Usuário não encontrado!");
					}
				}
				
				if (tipo.equals("admin")) {
					if (senha.equals("admin")) {
						if (login.equals("admin")) {
							request.getSession().setAttribute("tipo", tipo);
							response.sendRedirect("admin");
						} 
						else erros.add("Login inválido!");
					} else erros.add("Senha inválida!");
				return;
				}
				
			}
			
			/*
			if (!erros.isExisteErros()) {
				
				if (senha == "admin") {
					if (login == "admin") {
						response.sendRedirect("admin/");
					} 
					else erros.add("Login inválido!");
				} else erros.add("Senha inválida!");		
			}
			*/
			
		}
		request.getSession().invalidate();
		request.setAttribute("mensagens", erros);
		String URL = "/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
	}
}