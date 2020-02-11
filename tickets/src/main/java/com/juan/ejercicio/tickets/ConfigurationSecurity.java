package com.juan.ejercicio.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.juan.ejercicio.tickets.service.UsuarioTicketService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigurationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("usuarioTicketService")
	public UsuarioTicketService usuarioTicketService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioTicketService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.headers().frameOptions().sameOrigin().and()
		.authorizeRequests()
		.antMatchers("/css/*", "/js/*", "/img/*","/api/**", "/usuario/**")
		.permitAll()
	.and().formLogin()
		.loginPage("/login")
			.loginProcessingUrl("/logincheck")
			.usernameParameter("mail")
			.passwordParameter("password")
			.defaultSuccessUrl("/loginsuccess")
			.permitAll()
		.and().logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout")
			.permitAll().and().csrf().disable();
	}

}
