package com.matheus.demo.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.demo.domain.Estado;
import com.matheus.demo.repository.EstadoRepository;
import com.matheus.demo.service.exception.DataIntegrityViolationException;

@Service

public class EstadoService {

	@Autowired
	private EstadoRepository repo;
	
	public Estado find(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Estado.class.getName(),null));
	}
	
	public Estado insert (Estado obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Estado update(Estado obj) {
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
