package com.example.desafioHibernate1.services;

import java.util.List;

import com.example.desafioHibernate1.entities.Cliente;

	public interface ClienteServiceI {
	
	public void insertarCliente(Cliente cliente);
	
	public List<Cliente> listaClientes(); 
	
	public Cliente searchById(Long idCliente);
	
	public void eliminarCliente(Cliente cliente);
	
	public void actualizarCliente(Long idCliente,String nombre,String primerApellido,String segundoApellido,String docIdentidad);
	
	public Cliente searchByNombreApellido(String nombre,String apellido);

}
