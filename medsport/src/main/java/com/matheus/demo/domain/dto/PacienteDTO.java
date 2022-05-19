package com.matheus.demo.domain.dto;

import java.io.Serializable;
import java.util.Date;

import com.matheus.demo.domain.Paciente;


public class PacienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Date dataNasc;
	private String email;
	
	public PacienteDTO(Paciente obj) {
		id = obj.getId();
		nome = obj.getNome();
		dataNasc = obj.getDataNasc();
		email = obj.getEmail();
	}
	
	public PacienteDTO() {
		super();
	}
	public PacienteDTO(Integer id, String nome, Date dataNasc, String email, String cpf, Integer telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.email = email;        
      
}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
	
	
