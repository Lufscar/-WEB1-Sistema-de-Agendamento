package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.*;
import br.ufscar.dc.dsw.domain.*;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CriaCliente", urlPatterns = { "/cliente/criar" })
public class CriaClientesController extends HttpServlet {

    private static final long serialVersionUID = 1L;
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
        	/*if(request.getSession().getAttribute("admin") == null){
                response.sendRedirect("../login");
                return;
            }*/

            ClientesDAO clienteDAO = new ClientesDAO();
            Clientes cliente = new Clientes();
            
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setSenha(request.getParameter("senha"));
            cliente.setNome(request.getParameter("nome"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setSexo(request.getParameter("sexo"));
            /*String nascimentoStr = (request.getParameter("nascimento"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            cliente.setNascimento((Date) sdf.parse(nascimentoStr));*/
            
            clienteDAO.insert(cliente);
            response.sendRedirect("/SistemaAgendamento/Cliente.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}