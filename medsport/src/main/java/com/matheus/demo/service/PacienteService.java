package com.matheus.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.demo.domain.Paciente;
import com.matheus.demo.domain.dto.PacienteDTO;
import com.matheus.demo.repository.PacienteRepository;
import com.matheus.demo.service.exception.DataIntegrityViolationException;

@Service

public class PacienteService {

	@Autowired
	private PacienteRepository repo;

	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ",Tipo: " + Paciente.class.getName(), null));
	}

	public Paciente insert(Paciente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Paciente update(Paciente obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {

			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não e possivel excluir uma categoria que possui produtos");
		}

	}

	public List<Paciente> findAll() {

		return repo.findAll();
	}
	
	public Paciente fromDTO(PacienteDTO objDto) {
		return new Paciente(objDto.getId(), objDto.getNome(),objDto.getDataNasc(),objDto.getEmail(),null,null);
	}
}
