package com.matheus.demo.domain.dto;

import java.io.Serializable;
import java.util.Date;

import com.matheus.demo.domain.Funcionario;

public class FuncionarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Date dataNasc;
	private Integer telefone;
	
	public FuncionarioDTO (Funcionario obj) {
		
		id = obj.getId();
		nome = obj.getNome();
		dataNasc = obj.getDataNasc();
		telefone = obj.getTelefone();
		
	}
	
	
	public FuncionarioDTO() {
		
		super();
	}
	public FuncionarioDTO(Integer id, String nome, Date dataNasc, Integer telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
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
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
