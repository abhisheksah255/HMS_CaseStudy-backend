package com.abhisheksah.model;

import java.util.Optional;
import java.util.function.IntPredicate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="Guest")
public class Guest {

	@Id
	@NotNull(message = "GuestId can't be null")
	private long guestId;
	@Field
	@NotNull(message = "phone number must be of greater then 6 digit")
	private long phoneNumber;
	
	private String company;
	@NotNull(message = "It should not be null...")
//	@NotBlank(message = "It should not be null...")
	private String name;
	@Email(message = "write  like abhi@gmail.com...... must follow pattern")
	private String email;
	@NotNull(message="enter Male/Female")
	private String gender;
	@NotNull(message = "Write address like:---Lucknow,India")
	private String Address;
	
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guest(@NotNull(message = "GuestId can't be null")@Size(min=3,max=5,message="not be empty" ) long guestId,
			@NotNull(message = "phone number must be of greater then 6 digit") long phoneNumber,
			String company, @NotNull(message = "It should not be null...") String name,
			@Email(message = "write  like abhi@gmail.com...... must follow pattern") String email,
			@NotNull(message = "enter Male/Female") String gender,
			@NotNull(message = "Write address like:---Lucknow,India") String address) {
		super();
		this.guestId = guestId;
		this.phoneNumber = phoneNumber;
		this.company = company;
		this.name = name;
		this.email = email;
		this.gender = gender;
		Address = address;
	}

	public long getGuestId() {
		return guestId;
	}

	public void setGuestId(long guestId) {
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