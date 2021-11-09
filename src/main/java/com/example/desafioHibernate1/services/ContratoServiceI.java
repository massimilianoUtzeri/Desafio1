package com.example.desafioHibernate1.services;

import java.sql.Date;
import java.util.List;

import com.example.desafioHibernate1.entities.Cliente;
import com.example.desafioHibernate1.entities.Contrato;

public interface ContratoServiceI {
	
	public void insertarContrato(Contrato contrato);
	
	public List<Contrato> listaContratos(); 
	
	public Contrato searchById(long id);
	
	public void eliminarContrato(Contrato contrato);
	
	public void actualizarContrato(long id,Date fechaVigencia,Date fechaCaducidad,double precioMensual,Cliente cliente);

}
