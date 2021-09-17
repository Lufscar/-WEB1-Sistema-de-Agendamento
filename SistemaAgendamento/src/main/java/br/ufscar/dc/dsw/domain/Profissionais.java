package br.ufscar.dc.dsw.domain;

public class Profissionais {

    private String email;
    private String senha;
    private String cpf;
    private String nome;
    private String area;
    private String especialidade;
    private String qualificacoes;
    
    public Profissionais(String email,	String senha, String cpf, String nome, String area, String especialidade, String qualificacoes) {
    	this.email           = email;
    	this.senha           = senha;
    	this.cpf             = cpf;
    	this.nome            = nome;
    	this.area            = area;
    	this.especialidade   = especialidade;
    	this.qualificacoes  = qualificacoes;

	}
  
    
    
    public String getArea() {
		return area;
	}
    public String getEmail() {
		return email;
	}
    public String getCpf() {
		return cpf;
	}
    public String getEspecialidade() {
		return especialidade;
	}
    public String getNome() {
		return nome;
	}
    public String getQualificacoes() {
		return qualificacoes;
	}
    public String getSenha() {
		return senha;
	}
    public void setArea(String area) {
		this.area = area;
	}
    public void setCpf(String Cpf) {
    	this.cpf = cpf;
	}
    public void setEmail(String email) {
		this.email = email;
	}
    public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
    public void setNome(String nome) {
		this.nome = nome;
	}
    public void setQualificacoes(String qualificacoes) {
		this.qualificacoes = qualificacoes;
	}
    public void setSenha(String senha) {
		this.senha = senha;
	}
}
