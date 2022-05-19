package com.matheus.demo.domain.dto;

import java.io.Serializable;

import com.matheus.demo.domain.Endereco;

public class EnderecoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String cep;
	private String logradouro;
	private String bairro;
	
	public EnderecoDTO (Endereco obj) {
		
		id = obj.getId();
		cep = obj.getCep();
		logradouro = obj.getLogradouro();
		bairro = obj.getBairro();
		
	}
	
	
	
	public EnderecoDTO() {
		super();
	}


	public EnderecoDTO(Integer id, String cep, String logradouro, String bairro) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
		
	
	
}


