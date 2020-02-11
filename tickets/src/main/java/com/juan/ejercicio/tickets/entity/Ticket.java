package com.juan.ejercicio.tickets.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titulo;
	private String contenido;
	private Long idEstado;
	private String adjuntos;
	private ArrayList<UsuarioTicket> usuarioLogueado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraCarga;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getAdjuntos() {
		return adjuntos;
	}

	public void setAdjuntos(String adjuntos) {
		this.adjuntos = adjuntos;
	}

	public ArrayList<UsuarioTicket> getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(ArrayList<UsuarioTicket> usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

	public Date getFechaHoraCarga() {
		return fechaHoraCarga;
	}

	public void setFechaHoraCarga(Date fechaHoraCarga) {
		this.fechaHoraCarga = fechaHoraCarga;
	}
	
	
}
