package com.matheus.demo.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.demo.domain.Cidade;
import com.matheus.demo.repository.CidadeRepository;
import com.matheus.demo.service.exception.DataIntegrityViolationException;

@Service

public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public Cidade find(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Cidade.class.getName(),null));
	}
	
	public Cidade insert (Cidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Cidade update(Cidade obj) {
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

}
