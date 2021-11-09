package com.example.desafioHibernate1.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafioHibernate1.entities.Cliente;
import com.example.desafioHibernate1.entities.ClienteDaoI;

@Service
public class ClienteServiceImpl implements ClienteServiceI {
	
	@Autowired
	
	private ClienteDaoI clienteDao;

	@Override
	@Transactional
	public void insertarCliente(Cliente cliente) {
		
		clienteDao.insertarCliente(cliente);
	}

	@Override
	@Transactional
	public List<Cliente> listaClientes() {
		
		List <Cliente> listaClientes = clienteDao.listaClientes();
		return listaClientes;
		
	}

	@Override
	public Cliente searchById(Long idCliente) {
		
		Cliente cliente = clienteDao.searchById(idCliente);
		return cliente;
		
	}

	@Override
	@Transactional
	public void eliminarCliente(Cliente cliente) {
		
		clienteDao.eliminarCliente(cliente);
		
	}

	@Override
	@Transactional
	public void actualizarCliente(Long idCliente,String nombre,String primerApellido,String segundoApellido,String docIdentidad) {
		
		clienteDao.actualizarCliente(idCliente, nombre, primerApellido, segundoApellido, docIdentidad);
		
	}

	@Override
	@Transactional
	public Cliente searchByNombreApellido(String nombre, String apellido) {
		
		Cliente cliente = clienteDao.searchByNombreApellido(nombre, apellido);
		return cliente;
	}

}
