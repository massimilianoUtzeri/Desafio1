package com.example.desafioHibernate1.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContratoDaoImpl implements ContratoDaoI {
	
	@Autowired 
	private EntityManager entityManager;

	@Override
	public void insertarContrato(Contrato contrato) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.save(contrato);
		
		session.close();
	}

	@Override
	public List<Contrato> listaContratos() {
		
		Session session = entityManager.unwrap(Session.class);
		
		List<Contrato> listaContratos = (List) session.createQuery("SELECT *FROM Contrato").getResultList();
		
		session.close();
		
		return listaContratos;
		
	}

	@Override
	public Contrato searchById(long id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Contrato contrato = (Contrato) session.createQuery("FROM Contrato WHERE id="+id).uniqueResult();
		
		session.close();
		
		return contrato;
		
	}

	@Override
	public void eliminarContrato(Contrato contrato) {
		
		Session session = entityManager.unwrap(Session.class);
		
		entityManager.remove(entityManager.merge(contrato));
		
		session.close();
		
		
	}

	@Override
	public void actualizarContrato(long id, Date fechaVigencia, Date fechaCaducidad, double precioMensual,
			Cliente cliente) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.createQuery(" UPDATE Contrato set fechaVigencia =:fechaVigencia,fechaCaducidad =:fechaCaducidad,precioMensual=:precioMensual,cliente=:cliente WHERE id =: id").executeUpdate();
		
		session.close();
		
		
	}

}
