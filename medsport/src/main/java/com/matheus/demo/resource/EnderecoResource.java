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

import com.matheus.demo.domain.Endereco;
import com.matheus.demo.domain.dto.EnderecoDTO;
import com.matheus.demo.service.EnderecoService;

@RestController
@RequestMapping(value= "/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;
	
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Endereco> find(@PathVariable Integer id) {
				Endereco obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert  ( @RequestBody Endereco obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update( @RequestBody Endereco obj, @PathVariable Integer id) {
		
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
	public ResponseEntity<List<EnderecoDTO>> findPage() {
				List<Endereco> list = service.findAll();
				List<EnderecoDTO> listDto = list.stream().map(obj -> new EnderecoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
}
