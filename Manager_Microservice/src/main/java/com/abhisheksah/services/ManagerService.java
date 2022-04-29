package com.abhisheksah.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhisheksah.model.Manager;
import com.abhisheksah.repository.ManagerRepository;

@Service
public class ManagerService implements UserDetailsService {

	@Autowired
	private ManagerRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Manager foundedManager = repository.findByEmail(username);
		if (foundedManager == null)
			return null;
		String Email = foundedManager.getEmail();
		String Password = foundedManager.getPassword();
		return new User(Email, Password, new ArrayList<>());
	}
	
	public List<Manager> getAllManger(){
		List<Manager> manager=repository.findAll();
		System.out.println("Getting manager from db"+manager);
		return manager;
	}
}
