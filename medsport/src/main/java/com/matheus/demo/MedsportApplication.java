package com.matheus.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheus.demo.domain.Paciente;
import com.matheus.demo.repository.PacienteRepository;

@SpringBootApplication
public class MedsportApplication implements CommandLineRunner {

	
	@Autowired
	private PacienteRepository pacienteRepository;
	public static void main(String[] args) {
		SpringApplication.run(MedsportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Paciente pa = new Paciente(null, "matheus", sdf.parse("07/03/1999 00:00"), "matheuspastoridev@gmail.com", "44548701259", 1);
		
		pacienteRepository.saveAll(Arrays.asList(pa));
	}

}
