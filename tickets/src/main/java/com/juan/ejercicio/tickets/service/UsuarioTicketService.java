package com.juan.ejercicio.tickets.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.tomcat.jni.User;
import org.dom4j.util.UserDataDocumentFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.juan.ejercicio.tickets.entity.Ticket;
import com.juan.ejercicio.tickets.entity.UsuarioTicket;

@Service
public class UsuarioTicketService implements UserDetailsService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public UsuarioTicket actualizarUsuario(String id, String rol, String nombre, String apellido, String email,
			String password) throws Exception {
		
		validate(nombre, apellido, email, password);
		
		List<UsuarioTicket> usuarioExistentes = findUserByEmail(email);
		
		if (!usuarioExistentes.isEmpty()) {
			for (UsuarioTicket usuarioTicket : usuarioExistentes) {
				if (!usuarioTicket.getId().equals(id)) {
					throw new Exception("Ya existe un usuario registrado con este mail");
				}
			}
		}
		
		UsuarioTicket usuarioTicket = findUserById(id);
		
		String encodePassword = new BCryptPasswordEncoder().encode(password);
		
		usuarioTicket.setPassword(encodePassword);
		usuarioTicket.setNombre(nombre);
		usuarioTicket.setApellido(apellido);
		usuarioTicket.setEmail(email);
		
		for (UsuarioTicket usuarioRol : usuarioExistentes) {
			usuarioTicket.setRol(usuarioRol.getRol());			
		}
		
		return entityManager.merge(usuarioTicket);

	}
	
	public

	@Override
	public UserDetails loadUserByMail(String email) throws UsernameNotFoundException {

		List<UsuarioTicket> listUsuarioTicket = findUserById(email);

		User user = null;
		if (!listUsuarioTicket.isEmpty()) {
			UsuarioTicket usuarioTicket = listUsuarioTicket.get(0);
			List<GrantedAuthority> permission = new ArrayList<>();

			switch (usuarioTicket.getRol()) {
			case TECNICO:
				permission.add(new SimpleGrantedAuthority("TECNICO"));
				break;
			case ABONADO:
				permission.add(new SimpleGrantedAuthority("ABONADO"));
				break;
			}
			user = new User(usuarioTicket.getEmail(), usuarioTicket.getPassword(), permission);
		}

		return user;
	}

	public void validate(String nombre, String apellido, String email, String password) throws Exception {

		if (password == null || password.isEmpty()) {
			throw new Exception("La contraseña ingresada no puede estar vacia.");
		}

		if (nombre == null || nombre.isEmpty()) {
			throw new Exception("El nombre de usuario no puede estar vacio.");
		}

		if (apellido == null || apellido.isEmpty()) {
			throw new Exception("El apellido no puede estar vacio.");
		}

		if (email == null || email.isEmpty()) {
			throw new Exception("El email del usuario no puede estar vacio.");
		}

	}

	public UsuarioTicket findUserById(String id) {
		return entityManager.find(UsuarioTicket.class, id);
	}

	public List<UsuarioTicket> findUserByEmail(String email) {
		return entityManager.createQuery("SELECT ut FROM UserTicket ut WHERE ut.email = :email")
				.setParameter("email", email).getResultList();
	}

}
