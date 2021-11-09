package com.example.desafioHibernate1.services;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafioHibernate1.entities.Cliente;
import com.example.desafioHibernate1.entities.ClienteDaoI;
import com.example.desafioHibernate1.entities.Contrato;
import com.example.desafioHibernate1.entities.ContratoDaoI;

@Service
public class ContratoServiceImpl implements ContratoServiceI {

	@Autowired
	private ContratoDaoI contratoDao;
		
	@Override
	@Transactional
	public void insertarContrato(Contrato contrato) {
		contratoDao.insertarContrato(contrato);
		
	}

	@Override
	@Transactional
	public List<Contrato> listaContratos() {
		
		List <Contrato> listaContratos = contratoDao.listaContratos();
		return listaContratos;
	}

	@Override
	@Transactional
	public Contrato searchById(long id) {
		
		Contrato contrato = contratoDao.searchById(id);
		return contrato;
		
	}

	@Override
	@Transactional
	public void eliminarContrato(Contrato contrato) {
		
		contratoDao.eliminarContrato(contrato);
		
	}

	@Override
	@Transactional
	public void actualizarContrato(long id, Date fechaVigencia, Date fechaCaducidad, double precioMensual,
			Cliente cliente) {
		
		contratoDao.actualizarContrato(id, fechaVigencia, fechaCaducidad, precioMensual, cliente);
		
	}
	
	

}
