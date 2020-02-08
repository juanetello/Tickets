package com.juan.ejercicio.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juan.ejercicio.tickets.service.UsuarioTicketService;

@Controller
@RequestMapping("/usuario")
public class UsuarioTicketController {

	@Autowired
	private UsuarioTicketService UsuarioTicketService;
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
}
