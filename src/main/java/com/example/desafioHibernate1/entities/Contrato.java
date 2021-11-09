package com.example.desafioHibernate1.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "CONTRATO")
public class Contrato {
	
	private long id;
	private Date fechaVigencia;
	private Date fechaCaducidad;
	private double precioMensual;
	Cliente cliente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTRATO",unique = true,precision = 15,nullable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@DateTimeFormat
	@Column(name = "FECHA_VIGENCIA",nullable=false)
	public Date getFechaVigencia() {
		return fechaVigencia;
	}
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	
	@DateTimeFormat
	@Column(name = "FECHA_CADUCIDAD",nullable=false)
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	
	@Column(name = "PRECIO_MENSUAL",nullable=false,precision=15)
	public double getPrecioMensual() {
		return precioMensual;
	}
	public void setPrecioMensual(double precioMensual) {
		this.precioMensual = precioMensual;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE",nullable = false)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
