package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.ClientesDAO;
import br.ufscar.dc.dsw.dao.ConsultasDAO;
import br.ufscar.dc.dsw.dao.ProfissionaisDAO;
import br.ufscar.dc.dsw.domain.Clientes;
import br.ufscar.dc.dsw.domain.Consultas;
import br.ufscar.dc.dsw.domain.Profissionais;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@WebServlet(urlPatterns = "/Ctlcliente/*")
public class ClientesController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private ClientesDAO dao;

    @Override
    public void init() {
        dao = new ClientesDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {           
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                	Long id = Long.parseLong(request.getParameter("id"));
                    Clientes cliente = new Clientes(id);
                    dao.delete(cliente);
                    request.getSession().setAttribute("tipo", "admin");
                    response.sendRedirect("/SistemaAgendamento/Admin.jsp");
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException | ParseException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
    	ArrayList<Clientes> listaClientes = dao.getAll();
        request.setAttribute("listaClientes", listaClientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/clientes/lista.jsp");
        dispatcher.forward(request, response);
        */
    	request.getSession().setAttribute("tipo", "admin");
        response.sendRedirect("/SistemaAgendamento/Admin.jsp");
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/clientes/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Clientes cliente = dao.get(id);
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/clientes/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        
        Long id = Long.parseLong(request.getParameter("id"));
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        /*
         String startDateStr = request.getParameter("startDate");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//surround below line with try catch block as below code throws checked exception
	Date startDate = sdf.parse(startDateStr);
         * */
        
        String nascimentoStr = request.getParameter("nascimento");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nascimento = (Date) sdf.parse(nascimentoStr);
        
        Clientes cliente = new Clientes(id, cpf, email, senha, nome, telefone, sexo, nascimento);
        dao.insert(cliente);
        request.getSession().setAttribute("tipo", "admin");
        response.sendRedirect("/SistemaAgendamento/Admin.jsp");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        
        String nascimentoStr = request.getParameter("nascimento");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nascimento = (Date) sdf.parse(nascimentoStr);

        Clientes cliente = new Clientes(id, cpf, email, senha, nome, telefone, sexo, nascimento);
        dao.update(cliente);
        request.getSession().setAttribute("tipo", "admin");
        response.sendRedirect("/SistemaAgendamento/Admin.jsp");
    }

}