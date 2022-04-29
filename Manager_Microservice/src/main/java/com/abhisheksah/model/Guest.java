package com.abhisheksah.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="Guest")
public class Guest {

	@Id
	private int guestId;
	@Field
	private long phoneNumber;
	private String company;
	private String name;
	private String email;
	private String gender;
	private String Address;
	
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guest(int guestId, long phoneNumber, String company, String name, String email, String gender,
			String address) {
		super();
		this.guestId = guestId;
		this.phoneNumber = phoneNumber;
		this.company = company;
		this.name = name;
		this.email = email;
		this.gender = gender;
		Address = address;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", phoneNumber=" + phoneNumber + ", company=" + company + ", name=" + name
				+ ", email=" + email + ", gender=" + gender + ", Address=" + Address + "]";
	}

	
}
