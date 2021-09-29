package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Consultas;

public class ConsultasDAO extends GenericDAO {
	
    public void insert(Consultas consulta) throws Exception {
    	//confere se o cliente já possui consulta marcada
    	String sql = "SELECT * from CONSULTAS WHERE ano = ? and mes = ? and dia = ? and hora = ? and minuto = ? and cliente = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, consulta.getAno());
            statement.setInt(2, consulta.getMes());
            statement.setInt(3, consulta.getDia());
            statement.setInt(4, consulta.getHora());
            statement.setLong(5, consulta.getCliente());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                throw new Exception("Esse cliente já possui consulta agendada para esse horário");
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    	
    	//insere
        sql = "INSERT INTO Consultas (colsulta_id, cpf_C, cpf_P, nome_C, nome_P, area, especialidade, "+
    	"ano, mes, dia, hora) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setLong(1, consulta.getId());
            statement.setLong(2, consulta.getCliente());
            statement.setLong(3, consulta.getProfissional());
            statement.setString(4, consulta.getNome_C());
            statement.setString(5, consulta.getNome_P());
            statement.setString(6, consulta.getArea());
            statement.setString(7, consulta.getEspecialidade());
            statement.setInt(8, consulta.getAno());
            statement.setInt(9, consulta.getMes());
            statement.setInt(10, consulta.getDia());
            statement.setInt(11, consulta.getHora());
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

        String sql = "SELECT * FROM Consultas con ORDER BY con.data ASC";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long cliente = resultSet.getLong("id_C");
                Long profissional = resultSet.getLong("id_P");
                String nome_C = resultSet.getString("nome_C");
                String nome_P = resultSet.getString("nome_P");
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");
                int ano = resultSet.getInt("ano");
                int mes = resultSet.getInt("mes");
                int dia = resultSet.getInt("dia");
                int hora = resultSet.getInt("hora");
                
                Consultas consulta = new Consultas(id, cliente, profissional, nome_C, nome_P, area, especialidade, ano, mes, dia, hora);
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

        String sql = "SELECT * from Consultas con order by con.Data ASC";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long cliente = resultSet.getLong("id_C");
                Long profissional = resultSet.getLong("id_P");
                String nome_C = resultSet.getString("nome_C");
                String nome_P = resultSet.getString("nome_P");
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");
                int ano = resultSet.getInt("ano");
                int mes = resultSet.getInt("mes");
                int dia = resultSet.getInt("dia");
                int hora = resultSet.getInt("hora");
                
                Consultas consulta = new Consultas(id, cliente, profissional, nome_C, nome_P, area, especialidade, ano, mes, dia, hora);
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

    public ArrayList<Consultas> getbyCliente(Long id) throws Exception {
        
        String sql = "SELECT * from CONSULTAS c where c.id_C = ? order by c.agendamento desc";
        
        ArrayList<Consultas> listaConsultas = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	Long id_ = resultSet.getLong("id");
                Long cliente = resultSet.getLong("id_C");
                Long profissional = resultSet.getLong("id_P");
                String nome_C = resultSet.getString("nome_C");
                String nome_P = resultSet.getString("nome_P");
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");
                int ano = resultSet.getInt("ano");
                int mes = resultSet.getInt("mes");
                int dia = resultSet.getInt("dia");
                int hora = resultSet.getInt("hora");
                
                Consultas consulta = new Consultas(id_, cliente, profissional, nome_C, nome_P, area, especialidade, ano, mes, dia, hora);
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
    
    public ArrayList<Consultas> getbyProfissional(Long id) throws Exception {
       
        String sql = "SELECT * FROM CONSULTAS where id_P = ? order by ano desc, mes desc, dia desc, hora desc";
        
        ArrayList<Consultas> listaConsultas = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	Long id_ = resultSet.getLong("id");
                Long cliente = resultSet.getLong("id_C");
                Long profissional = resultSet.getLong("id_P");
                String nome_C = resultSet.getString("nome_C");
                String nome_P = resultSet.getString("nome_P");
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");
                int ano = resultSet.getInt("ano");
                int mes = resultSet.getInt("mes");
                int dia = resultSet.getInt("dia");
                int hora = resultSet.getInt("hora");
                
                Consultas consulta = new Consultas(id_, cliente, profissional, nome_C, nome_P, area, especialidade, ano, mes, dia, hora);
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
}
