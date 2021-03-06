package com.matheus.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.demo.domain.Paciente;
import com.matheus.demo.domain.dto.PacienteDTO;
import com.matheus.demo.service.PacienteService;

@RestController
@RequestMapping(value= "/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteService service;
	
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Paciente> find(@PathVariable Integer id) {
				Paciente obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert  ( @RequestBody Paciente obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update( @RequestBody Paciente obj, @PathVariable Integer id) {
		
		obj.setId(id);
	obj = service.update(obj);
	return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> findPage() {
				List<Paciente> list = service.findAll();
				List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
}
