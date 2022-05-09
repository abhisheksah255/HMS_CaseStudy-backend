package com.abhisheksah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksah.model.AuthRequest;
import com.abhisheksah.model.AuthenticationRequest;
import com.abhisheksah.model.AuthenticationResponse;
import com.abhisheksah.model.User;
import com.abhisheksah.repository.UserRepository;
import com.abhisheksah.services.CustomUserDetailService;
import com.abhisheksah.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:3000")
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
	
	//this is diffent method 
	
	
	
	
	/*
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository adminRepository;
	
	@Autowired
	AuthenticationManager authenticates;
	
	@Autowired
	CustomUserDetailService userservice;
	
	@Autowired
	JwtUtil jwtutil;
	
	
	@PostMapping("/signin")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authreq){
		String username=authreq.getUsername();
		String password= authreq.getPassword();
		try {
			authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				
		}
		catch(Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse(" Invalid Credentials..!"));
		}
		
		UserDetails userdetails= userservice.loadUserByUsername(username);
		
		String jwt = jwtutil.generateToken(userdetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@PostMapping("/signup")
	private ResponseEntity<AuthenticationResponse>subscribeClient(@RequestBody AuthenticationRequest authreq){
		User usermodel =new User();	
		
		usermodel.setUsername(authreq.getUsername());
		//usermodel.setPassword(authreq.getPassword());
		usermodel.setPassword(passwordEncoder.encode(authreq.getPassword()));
		try {
			adminRepository.insert(usermodel);
		}
		catch(Exception e){
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
					("username already exit ") , HttpStatus.OK);
		}
		
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
				("Successful subs for client " +authreq.getUsername()), HttpStatus.OK);
	}
	
	
	@GetMapping("/test")
	private String testingtoken() {
		try {
			return "Testing Successful...!";	
		}
		catch(Exception e) {
			return "Please login first..!";
		}
	}
	*/
}
