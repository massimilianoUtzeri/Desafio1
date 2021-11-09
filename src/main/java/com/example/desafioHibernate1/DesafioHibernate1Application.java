package com.example.desafioHibernate1;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafioHibernate1.entities.Cliente;
import com.example.desafioHibernate1.entities.Contrato;
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
		
		//Crear y Insertar cliente
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Alejandro");
		cliente1.setPrimerApellido("Ramirez");
		cliente1.setSegundoApellido("Castro");
		cliente1.setDocIdentidad("789a57654");
		
		Cliente cliente2 = new Cliente();
		cliente1.setNombre("Massimiliano");
		cliente1.setPrimerApellido("Utzeri");
		cliente1.setSegundoApellido("Giuliani");
		cliente1.setDocIdentidad("442a57654");
		
		Cliente cliente3 = new Cliente();
		cliente1.setNombre("Paulo");
		cliente1.setPrimerApellido("Costa");
		cliente1.setSegundoApellido("Hernandez");
		cliente1.setDocIdentidad("666241asd");
		
		clienteService.insertarCliente(cliente1);
		clienteService.insertarCliente(cliente2);
		clienteService.insertarCliente(cliente3);
		
		
		//Lista clientes
		List<Cliente> listaClientes = clienteService.listaClientes();
		for(Cliente x : listaClientes) {
			System.out.println(x.toString());
		}
		
		//SearchById
		Cliente clienteBusqueda = clienteService.searchById(cliente1.getId());
		System.out.println(clienteBusqueda.toString());
		
		//Eliminar cliente
		clienteService.eliminarCliente(cliente2);
		
		//Actualizar cliente
		clienteService.actualizarCliente(cliente1.getId(), "Juan", "Garcia", "Ramirez", "145asd58");
		System.out.println(cliente1.toString());
		
		//Busqueda cliente
		Cliente clienteEncontrado = clienteService.searchByNombreApellido("Juan", "Garcia");
		System.out.println(clienteEncontrado.toString());
		
		
	}

}
