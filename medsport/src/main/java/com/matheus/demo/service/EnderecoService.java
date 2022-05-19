package com.matheus.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.demo.domain.Endereco;
import com.matheus.demo.domain.dto.EnderecoDTO;
import com.matheus.demo.repository.EnderecoRepository;
import com.matheus.demo.service.exception.DataIntegrityViolationException;

@Service

public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;
	
	public Endereco find(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Endereco.class.getName(),null));
	}
	
	public Endereco insert (Endereco obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Endereco update(Endereco obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void  delete(Integer id) {
		find(id);
		try {
			
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e ) {
		throw  new DataIntegrityViolationException("Não e possivel excluir uma categoria que possui produtos");
		}
	
	}
	
	public List<Endereco> findAll() {

		return repo.findAll();
	}
	
	public Endereco fromDTO(EnderecoDTO objDto) {
		return new Endereco(objDto.getId(), objDto.getLogradouro(),null,null,objDto.getBairro(),objDto.getCep(),null);
	}
}
