package com.example.desafioHibernate1.entities;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ClienteDaoImpl implements ClienteDaoI{

	@Autowired 
	private EntityManager entityManager;
	
	@Override
	public void insertarCliente(Cliente cliente) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.save(cliente);
		
		session.close();
		
	}

	@Override
	public List<Cliente> listaClientes() {
		
		Session session = entityManager.unwrap(Session.class);
		
		List<Cliente> listaClientes = (List) session.createQuery("SELECT *FROM Cliente").getResultList();
		
		session.close();
		
		return listaClientes;
	}

	@Override
	public Cliente searchById(Long idCliente) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Cliente cliente = (Cliente) session.createQuery("FROM Cliente WHERE id="+idCliente).uniqueResult();
		
		session.close();
		
		return cliente;
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		
		Session session = entityManager.unwrap(Session.class);
		
		entityManager.remove(entityManager.merge(cliente));
		
		session.close();
		
	}

	@Override
	public void actualizarCliente(Long idCliente,String nombre,String primerApellido,String segundoApellido,String docIdentidad) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.createQuery(" UPDATE Cliente set nombre =:nombre,primerApellido =:primerApellido,segundoApellido=:segundoApellido,docIdentidad=:docIdentidad WHERE id =: idCliente").executeUpdate();
		
		session.close();
		
	}

	@Override
	public Cliente searchByNombreApellido(String nombre, String apellido) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Cliente cliente = (Cliente) session.createQuery("FROM Cliente WHERE nombre="+nombre+"AND primerApellido="+apellido).uniqueResult();
		
		session.close();
		return cliente;
		
	}

}
