package com.abhisheksah.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.abhisheksah.services.ReceptionistService;

@EnableWebSecurity
public class SecurityCofiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private ReceptionistService receptionistService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//super.configure(auth);
	/*
		auth.inMemoryAuthentication()
		.withUser("Abhi")
		.password(this.passwordEncoder().encode("Abhi"))
		.roles("Receptionist");
	*/
		auth.inMemoryAuthentication()
		.withUser("Abhi")
		.password("Abhi")
		.roles("Receptionist");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests()
		.antMatchers("/Receptionist/addRecptionist","/Receptionist/auth")
		.permitAll().anyRequest().authenticated()
		.and().formLogin();
		
	}

	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
		//return new BCryptPasswordEncoder(10);
	}

}
