package com.juan.ejercicio.tickets.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RespuestaTicket {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 private ArrayList<Ticket> tickets;
	 private String contenido;
	 private Date fechaHora;
	 private ArrayList<UsuarioTicket> usuarioLogueado;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public ArrayList<UsuarioTicket> getUsuarioLogueado() {
		return usuarioLogueado;
	}
	public void setUsuarioLogueado(ArrayList<UsuarioTicket> usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}
	 	 	 
}
