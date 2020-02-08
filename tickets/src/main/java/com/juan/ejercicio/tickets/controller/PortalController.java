package com.juan.ejercicio.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalController {
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/loginsuccess")
	public String singIn() {
		return "index.html";
	}

}
