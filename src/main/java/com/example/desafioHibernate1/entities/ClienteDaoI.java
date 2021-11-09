package com.example.desafioHibernate1.entities;

import java.util.List;

public interface ClienteDaoI {
	
	public void insertarCliente(Cliente cliente);
	
	public List<Cliente> listaClientes(); 
	
	public Cliente searchById(Long idCliente);
	
	public void eliminarCliente(Cliente cliente);
	
	public void actualizarCliente(Long idCliente,String nombre,String primerApellido,String segundoApellido,String docIdentidad);
	
	public Cliente searchByNombreApellido(String nombre,String apellido);

}
