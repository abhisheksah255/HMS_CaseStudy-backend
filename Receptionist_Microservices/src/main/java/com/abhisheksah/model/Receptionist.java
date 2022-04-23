package com.abhisheksah.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Receptionist")
public class Receptionist {

	@Id
	private String id;
	private String email;
	private String password;
	
	
	
	public Receptionist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receptionist(String id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Receptionist [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
