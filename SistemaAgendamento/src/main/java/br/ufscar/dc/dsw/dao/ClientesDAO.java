package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


import br.ufscar.dc.dsw.domain.Clientes;
import br.ufscar.dc.dsw.domain.Profissionais;
import br.ufscar.dc.dsw.domain.Consultas;

public class ClientesDAO extends GenericDAO {

    public void insert(Clientes cliente) {

        String sql = "INSERT INTO CLIENTES (id, cpf, email, senha, nome, telefone, sexo, nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setLong(1, cliente.getId());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getNome());
            statement.setString(6, cliente.getTelefone());
            statement.setString(7, cliente.getSexo());
            statement.setDate(8, (Date) cliente.getNascimento());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Clientes> getAll() {

        List<Clientes> listaClientes = new ArrayList<>();

        String sql = "SELECT * from CLIENTES order by nome";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String cpf = resultSet.getString("cpf");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Date nascimento = resultSet.getDate("nascimento");
                Clientes cliente = new Clientes(id, cpf, email, senha, nome, telefone, sexo, nascimento);

                listaClientes.add(cliente);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }

    public void delete(Clientes cliente) {
        String sql = "DELETE FROM CLIENTES where cpf = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, Clientes.getCpf());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Clientes cliente) {
        String sql = "UPDATE CLIENTES SET cpf = ?, email = ?, senha = ?, nome = ?, telefone = ?, sexo = ?, nascimento = ? ";
        sql += "WHERE cpf = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setLong(1, cliente.getId());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getNome());
            statement.setString(6, cliente.getTelefone());
            statement.setString(7, cliente.getSexo());
            statement.setDate(8, (Date) cliente.getNascimento());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Clientes get(Long id) {
        Clientes cliente = null;

        String sql = "SELECT * from CLIENTES where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	String cpf_c = resultSet.getString("cpf");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Date nascimento = resultSet.getDate("nascimento");
                		
                cliente = new Clientes(id, cpf_c, email, senha, nome, telefone, sexo, nascimento);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
}