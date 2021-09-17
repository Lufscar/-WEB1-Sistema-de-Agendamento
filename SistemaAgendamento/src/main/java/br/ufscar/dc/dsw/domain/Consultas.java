package br.ufscar.dc.dsw.domain;
import java.util.Date;


public class Consultas {

	private Long id;
	private Clientes cliente;
	private Profissionais profissional;
	private Date data;
	private Integer hora;
	
	
	public Consultas(Long id, Clientes cliente, Profissionais profissional, Date data, Integer hora){
		this.id = id;
		this.cliente = cliente;
		this.profissional = profissional;
		this.data = data;
		this.hora = hora;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Clientes getCliente() {
		return cliente;
	}
    
    public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
    
    public Profissionais getProfissional() {
		return profissional;
	}
    
    public void setProfissional(Profissionais profissional) {
		this.profissional = profissional;
	}
    
    public Date getData() {
		return data;
	}
    
	public void setData(Date data) {
		this.data = data;
	}
	
	public Integer getHora() {
		return hora;
	}
	
	public void setHora(Integer hora) {
		this.hora = hora;
	}

}
