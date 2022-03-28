package com.matheus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheus.demo.domain.Cidade;

@Repository
public interface CidadeRepository  extends JpaRepository <Cidade, Integer> {
	@Query(value="select * from paciente where id = ?",nativeQuery = true )
	Cidade find(Integer id);

}
