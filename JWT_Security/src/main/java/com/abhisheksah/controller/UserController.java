package com.abhisheksah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksah.model.AuthRequest;
import com.abhisheksah.util.JwtUtil;

@RestController
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome() {
		return "welcome to JWT Security";
	}
	
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest)throws Exception {
		try {
			//here we will just take the help of authenticationmanager to 
			//authenticate the username and password
			
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		}catch(Exception ex) {
		throw new Exception("invalid username/password")	;
		}
		//if authentiation success then only generate token for us
		//and this will give string encrypted code
		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
