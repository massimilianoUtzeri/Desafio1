package com.example.desafioHibernate1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafioHibernate1.entities.Cliente;
import com.example.desafioHibernate1.services.ClienteServiceI;
import com.example.desafioHibernate1.services.ClienteServiceImpl;

@SpringBootApplication
public class DesafioHibernate1Application implements CommandLineRunner {
	
	@Autowired
	ClienteServiceI clienteService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioHibernate1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Alejandro");
		cliente1.setPrimerApellido("Ramirez");
		cliente1.setSegundoApellido("Castro");
		cliente1.setDocIdentidad("789a57654");
		
		clienteService.insertarCliente(cliente1);
		
		
	}

}
