package com.juan.ejercicio.tickets.entity;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titulo;
	private String contenido;
	private ArrayList<String> estados;
	private String adjuntos;
	private Date fechaHora;
	private ArrayList<UsuarioTicket> usuarioLogueado;

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

	public ArrayList<String> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<String> estados) {
		this.estados = estados;
	}

	public String getAdjuntos() {
		return adjuntos;
	}

	public void setAdjuntos(String adjuntos) {
		this.adjuntos = adjuntos;
	}

	public Date getFechahora() {
		return fechaHora;
	}

	public void setFechahora(Date fechahora) {
		this.fechaHora = fechahora;
	}

	public ArrayList<UsuarioTicket> getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(ArrayList<UsuarioTicket> usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

}
