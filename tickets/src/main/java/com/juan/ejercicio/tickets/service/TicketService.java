package com.juan.ejercicio.tickets.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.juan.ejercicio.tickets.entity.Ticket;

@Service
public class TicketService {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void actualizarTicket(Ticket ticket) throws Exception {

		if (ticket.getTitulo() == null || ticket.getTitulo().isEmpty()) {
			throw new Exception("El titulo no puede estar nulo o vacío");
		}

		if (ticket.getContenido() == null || ticket.getContenido().isEmpty()) {
			throw new Exception("La descripción no puede ser nula o vacía");
		}

		List<Ticket> ticketsExistentes = findById(ticket.getId());
		for (Ticket tickets : ticketsExistentes) {
			if (!tickets.getId().equals(ticket.getId())) {
				throw new Exception("El id ya esta siendo usado.");
			}
		}
		entityManager.merge(ticket);
	}

	@Transactional
	public void borrarTicket(Long id) {
		Ticket ticket = entityManager.find(Ticket.class, id);
		entityManager.merge(ticket);
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> findById(Long id) {
		return entityManager.createQuery("SELECT ti FROM Ticket ti WHERE ti.id = :id").setParameter("id", id)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> listar() {
		return entityManager.createQuery("SELECT ti FROM Ticket ti WHERE ti.fecha_hora IS NULL ORDER BY ti.id")
				.getResultList();
	}

}
