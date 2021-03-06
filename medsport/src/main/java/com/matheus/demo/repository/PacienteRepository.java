package com.matheus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheus.demo.domain.Paciente;

@Repository
public interface PacienteRepository  extends JpaRepository <Paciente, Integer> {
	@Query(value="select * from paciente where id = ?",nativeQuery = true )
	Paciente find(Integer id);

}
