package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Clientes;
import br.ufscar.dc.dsw.domain.Profissionais;
import br.ufscar.dc.dsw.domain.Consultas;

public class ProfissionaisDAO extends GenericDAO {

    public void insert(Profissionais profissional) {

        String sql = "insert into PROFISSIONAIS(cpf, email, senha, nome, area, especialidade)  VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, profissional.getArea());
            statement.setString(2, profissional.getEmail());
            statement.setString(3, profissional.getCpf());
            statement.setString(4, profissional.getEspecialidade());
            statement.setString(5, profissional.getNome());
            statement.setString(6, profissional.getQualificacoes());
            statement.setString(7, profissional.getSenha());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Profissionais> getAll() {

        List<Profissionais> listaProfissionais = new ArrayList<>();

        String sql = "SELECT * from Profissionais order by nome ASC";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");
                String qualificacoes = resultSet.getString("qualificacoes");
                Profissionais profissional = new Profissionais(email, senha, cpf, nome, area, especialidade, qualificacoes);
                listaProfissionais.add(profissional);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaProfissionais;
    }

    public void delete(Profissionais profissional) {
        String sql = "DELETE FROM Profissionais where cpf = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, profissional.getCpf());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Profissionais profissional) {
        String sql = "UPDATE Profissionais SET profissional = ?, autor = ?, senha = ?, nome = ?, area = ?, especialidade = ?, qualificacoes = ?";
        sql += ", WHERE cpf = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, profissional.getArea());
            statement.setString(2, profissional.getEmail());
            statement.setString(3, profissional.getCpf());
            statement.setString(4, profissional.getEspecialidade());
            statement.setString(5, profissional.getNome());
            statement.setString(6, profissional.getQualificacoes());
            statement.setString(7, profissional.getSenha());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Profissionais get(String cpf) {
    	Profissionais profissional = null;

    	String sql = "SELECT * from Profissionais order by area ASC, order by especialidade DESC";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setNString(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {              
            	String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");
                String qualificacoes = resultSet.getString("qualificacoes");
 
                profissional = new Profissionais(cpf, email, senha, nome, area, especialidade, qualificacoes);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profissional;
    }
}