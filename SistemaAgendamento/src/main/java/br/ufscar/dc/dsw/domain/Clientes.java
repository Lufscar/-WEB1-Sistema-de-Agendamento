package br.ufscar.dc.dsw.domain;
import java.util.Date;



public class Clientes{

	private Long id;
    private static String cpf;
    private String email;
    private String senha;
	private String nome;
	private String telefone;
	private String sexo;
	private Date nascimento;

    public Clientes(Long id, String cpf, String email, String senha, String nome, String telefone, String sexo, Date nascimento) {
    	this.id = id;
		this.cpf = cpf;
        this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
		this.sexo = sexo;
		this.nascimento = nascimento;
    }
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public static String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
}