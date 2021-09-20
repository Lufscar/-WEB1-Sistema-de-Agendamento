package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Clientes;
import br.ufscar.dc.dsw.domain.Profissionais;
import br.ufscar.dc.dsw.domain.Consultas;

public class ConsultasDAO extends GenericDAO {
	
    public void insert(Consultas consulta) {

        String sql = "INSERT INTO Consultas (colsulta_id, cpf_C, cpf_P, data, hora) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setLong(1, consulta.getId());
            statement.setString(2, consulta.getCliente().getCpf());
            statement.setString(3, consulta.getProfissional().getCpf());
            statement.setDate(4, java.util.Date(consulta.getData()));
            statement.setInt(5, consulta.getHora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*R6 - Lista de todas as Consultas de um cliente*/
    public List<Consultas> getAllConsultas() {

        List<Consultas> listaConsultas = new ArrayList<>();

        String sql = "SELECT * from Consultas con, Clientes cli where con.cpf_C = cli.cpf order by con.data ASC";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Date data = resultSet.getDate("data");
                Integer hora = resultSet.getInt("hora");
                           
                String cpf_C = resultSet.getString("cpf");
                String email_C = resultSet.getString("email");
                String senha_C = resultSet.getString("senha");
                String nome_C = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Date nascimento = resultSet.getDate("nascimento");
                Clientes cliente = new Clientes(cpf_C, email_C, senha_C, nome_C, telefone, sexo, nascimento);
                
                String email_P = resultSet.getString("email");
                String senha_P = resultSet.getString("senha");
                String cpf_P = resultSet.getString("cpf");
                String nome_P = resultSet.getString("nome");
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");
                String qualificacoes = resultSet.getString("qualificacoes");
                Profissionais profissional = new Profissionais(email_P, senha_P, cpf_P, nome_P, area, especialidade, qualificacoes);
     
                Consultas consulta = new Consultas(id, cliente, profissional, data, hora);
                listaConsultas.add(consulta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsultas;
    }
    
    /*R7 - Lista de todas as Consultas de um Profissional*/
    public List<Consultas> getAllProfissional() {

        List<Consultas> listaConsultas = new ArrayList<>();

        String sql = "SELECT * from Consultas con, Profissionais pro where con.cpf_P = pro.cpf order by con.Data ASC";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Date data = resultSet.getDate("data");
                Integer hora = resultSet.getInt("hora");
                
                String cpf_C = resultSet.getString("cpf");
                String email_C = resultSet.getString("email");
                String senha_C = resultSet.getString("senha");
                String nome_C = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Date nascimento = resultSet.getDate("nascimento");
                Clientes cliente = new Clientes(cpf_C, email_C, senha_C, nome_C, telefone, sexo, nascimento);
                
                String email_P = resultSet.getString("email");
                String senha_P = resultSet.getString("senha");
                String cpf_P = resultSet.getString("cpf");
                String nome_P = resultSet.getString("nome");
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");
                String qualificacoes = resultSet.getString("qualificacoes");
                Profissionais profissional = new Profissionais(email_P, senha_P, cpf_P, nome_P, area, especialidade, qualificacoes);
     
                Consultas consulta = new Consultas(id, cliente, profissional, data, hora);
                listaConsultas.add(consulta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsultas;
    }
    
    
    
    public void delete(Consultas consulta) {
        String sql = "DELETE FROM Consultas where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, consulta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
