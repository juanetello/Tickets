package com.juan.ejercicio.tickets.entity;

public class Estados {

	private Long idEstado;
	private String codigoEstado;
	private String nombreEstado;

	public Estados(Long idEstado, String codigoEstado, String nombreEstado) {
		super();
		this.idEstado = idEstado;
		this.codigoEstado = codigoEstado;
		this.nombreEstado = nombreEstado;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

}
