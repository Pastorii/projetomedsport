package com.matheus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheus.demo.domain.Estado;

@Repository
public interface EstadoRepository  extends JpaRepository <Estado, Integer> {
	@Query(value="select * from paciente where id = ?",nativeQuery = true )
	Estado find(Integer id);

}
