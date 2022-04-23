package com.abhisheksah.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhisheksah.model.Receptionist;
import com.abhisheksah.repository.ReceptionistRepository;

@Service
public class ReceptionistService implements UserDetailsService{

	@Autowired
	private ReceptionistRepository receptionistRepository;
	
	
	public List<Receptionist> getReceptionist(){
	List<Receptionist> receptionistdata=receptionistRepository.findAll();
	System.out.println("---:Geting data from Database:--"+receptionistdata);
	return receptionistdata;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Receptionist findReceptionist=receptionistRepository.findByEmail(username);
		if (findReceptionist==null)
			return null;
		String Email=findReceptionist.getEmail();
		String Password=findReceptionist.getPassword();
		return new User(Email,Password,new ArrayList<>());
	}


	

	
}
