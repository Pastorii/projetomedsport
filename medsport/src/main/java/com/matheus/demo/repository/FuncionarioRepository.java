package com.matheus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheus.demo.domain.Funcionario;

@Repository
public interface FuncionarioRepository  extends JpaRepository <Funcionario, Integer> {
	@Query(value="select * from paciente where id = ?",nativeQuery = true )
	Funcionario find(Integer id);

}
