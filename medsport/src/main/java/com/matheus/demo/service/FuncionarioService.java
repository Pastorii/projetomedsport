package com.matheus.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.demo.domain.Funcionario;
import com.matheus.demo.domain.dto.FuncionarioDTO;
import com.matheus.demo.repository.FuncionarioRepository;
import com.matheus.demo.service.exception.DataIntegrityViolationException;

@Service

public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Funcionario.class.getName(),null));
	}
	
	public Funcionario insert (Funcionario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Funcionario update(Funcionario obj) {
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
	
	

	public List<Funcionario> findAll() {

		return repo.findAll();
	}
	
	public Funcionario fromDTO(FuncionarioDTO objDto) {
		return new Funcionario(objDto.getId(), objDto.getNome(),objDto.getDataNasc(),null,null,objDto.getTelefone());
	}
	


}
