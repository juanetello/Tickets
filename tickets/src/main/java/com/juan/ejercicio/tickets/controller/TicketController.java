package com.juan.ejercicio.tickets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.juan.ejercicio.tickets.entity.Ticket;
import com.juan.ejercicio.tickets.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/listado")
	public String listado(ModelMap modelMap) {

		List<Ticket> tickets = new ArrayList<Ticket>();

		tickets = ticketService.listar();

		modelMap.put("listado", tickets);

		return "listado_ticket.html";

	}

	@PostMapping("/actualizar")
	public String actualizarTicket(ModelMap modelMap, @RequestParam Long id, @RequestParam String titulo,
			@RequestParam String contenido, @RequestParam ArrayList<String> estados) {
		
		Ticket ticket = new Ticket();
		
		if (id != null) {
			ticket = (Ticket) ticketService.findById(id);
		}
		
		ticket.setId(id);
		ticket.setTitulo(titulo);
		ticket.setContenido(contenido);
		ticket.setEstados(estados);
		
		try {
			ticketService.actualizarTicket(ticket);
			return "redirect:/tickets/listado";
		} catch (Exception e) {
			modelMap.put("error", e.getMessage());
			modelMap.put("ticket", ticket);
		}
		
		return "ticket_form.html";

	}
	
	@GetMapping("/modificacion")
	public String modificarTicket(ModelMap modelMap, @RequestParam Long id) {
		Ticket ticket = (Ticket) ticketService.findById(id);
		modelMap.put("ticket", ticket);
		return "ticket_form.html";
	}
	
	@GetMapping("/create")
	public String create(ModelMap modelMap) {
		modelMap.put("ticket", new Ticket());
		return "ticket_form.html";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(ModelMap modelMap, @RequestParam Long id) {
		ticketService.borrarTicket(id);
		return "redirect:/tickets/listado";
	}

}
