package com.matheus.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheus.demo.domain.Cidade;
import com.matheus.demo.domain.Endereco;
import com.matheus.demo.domain.Estado;
import com.matheus.demo.domain.Funcionario;
import com.matheus.demo.domain.Paciente;
import com.matheus.demo.repository.CidadeRepository;
import com.matheus.demo.repository.EnderecoRepository;
import com.matheus.demo.repository.EstadoRepository;
import com.matheus.demo.repository.FuncionarioRepository;
import com.matheus.demo.repository.PacienteRepository;

@SpringBootApplication
public class MedsportApplication implements CommandLineRunner {

	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MedsportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		
		Estado est = new Estado(null, "Paraná");
		
		Cidade cid = new Cidade(null, "Arapongas",est);
		est.getCidades().addAll(Arrays.asList(cid));
		
		estadoRepository.saveAll(Arrays.asList(est));
		cidadeRepository.saveAll(Arrays.asList(cid));
		
		Paciente pa = new Paciente(null, "silvao", sdf.parse("01/05/1998 00:00"), "silvao@gmail.com","123457890" , null);
		Endereco end = new Endereco(null, "Tiriba Fogo", "304", "Atras da Colibri Moveis", "Alto da Boa Vista", "86706763",pa);
		pa.getEndereco().addAll(Arrays.asList(end));
		
		pacienteRepository.saveAll(Arrays.asList(pa));
		enderecoRepository.saveAll(Arrays.asList(end));
		
		Funcionario fun = new Funcionario(null, "Romario", sdf.parse("01/05/1997 00:30"), "romario@gmail.com", "10024018015", null); 
		
	
		
		
		
		funcionarioRepository.saveAll(Arrays.asList(fun));
		
		
	}

}
