package com.abhisheksah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksah.model.Manager;
import com.abhisheksah.repository.ManagerRepository;
import com.abhisheksah.security.ManagerAuthResponse;
import com.abhisheksah.services.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerService service;
	@Autowired
	private ManagerRepository repository;
	@Autowired
	private AuthenticationManager authenticationManager;



@PostMapping("/addmanager")
public ResponseEntity<?> addManager(@RequestBody Manager manager){
	String email =manager.getEmail();
	String password=manager.getPassword();
	
	Manager newManager= new Manager();
	newManager.setEmail(email);
	newManager.setPassword(password);
	try
	{
		repository.save(manager);
	}catch(Exception e) {
		return ResponseEntity.ok(new ManagerAuthResponse("Error creating manager"+email));
	}
return	ResponseEntity.ok(new ManagerAuthResponse("Successfully created Manager " + email));
}

@PostMapping("/auth")
private ResponseEntity<?> authManager(@RequestBody Manager managerInfo) {
	String email = managerInfo.getEmail();
	String password = managerInfo.getPassword();
	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
	} catch (Exception e) {
		return ResponseEntity.ok(new ManagerAuthResponse("Error during Manager Authentication" + email));
	}
	return ResponseEntity.ok(new ManagerAuthResponse("Successfully Authenticated Manager" + email));
}


@GetMapping("/manager")
public List<Manager> findAllmanagers() {
	return service.getAllManger();
}



}