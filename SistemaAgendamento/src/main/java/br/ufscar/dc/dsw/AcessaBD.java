package br.ufscar.dc.dsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBD {
	
	public static void main(String[] args) {
		try {
	
			/* Setup para uso do banco de dados MySQL */
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/Agendamento";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "root");
		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from CLIENTES");
			while (rs.next()) {
				System.out.print(rs.getInt("CPF"));
				System.out.print(", " + rs.getString("Email"));
				System.out.print(", " + rs.getString("Senha"));
				System.out.print(", " + rs.getString("Nome"));
				System.out.print(", " + rs.getString("Telefone"));
				System.out.print(", " + rs.getString("Sexo"));
				System.out.print(", " + rs.getString("Data de Nascimento"));
			}
			/*
			rs = stmt.executeQuery("select * from PROFISSIONAIS");
			while (rs.next()) {
				System.out.print(rs.getInt("CPF"));
				System.out.print(", " + rs.getString("Email"));
				System.out.print(", " + rs.getString("Senha"));
				System.out.print(", " + rs.getString("Nome"));
				System.out.print(", " + rs.getString("Area"));
				System.out.print(", " + rs.getString("Especialidade"));
			}
			
			ResultSet rs = stmt.executeQuery("select * from CONSULTAS");
			while (rs.next()) {
				System.out.print(rs.getInt("CPF Cliente"));
				System.out.print(", " + rs.getInt("CPF Profissional"));
				System.out.print(", " + rs.getString("Data/Hora da Consulta"));
			}
			*/
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("A classe do driver de conexão não foi encontrada!");
		} catch (SQLException e) {
			System.out.println("O comando SQL não pode ser executado!");
		}
	}
}
