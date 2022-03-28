package com.matheus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheus.demo.domain.Endereco;

@Repository
public interface EnderecoRepository  extends JpaRepository <Endereco, Integer> {
	@Query(value="select * from paciente where id = ?",nativeQuery = true )
	Endereco find(Integer id);

}
