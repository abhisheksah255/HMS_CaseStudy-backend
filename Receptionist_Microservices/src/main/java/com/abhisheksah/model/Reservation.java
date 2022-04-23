package com.abhisheksah.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Reservation")
public class Reservation {
	@Id
	private int code;
	@Field
	private int numberofchildren;
	private int numberofadults;
	private Date checkinDate;
	private Date checkoutDate;
	private String status;
	private int numberofnights;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int code, int numberofchildren, int numberofadults, Date checkinDate, Date checkoutDate,
			String status, int numberofnights) {
		super();
		this.code = code;
		this.numberofchildren = numberofchildren;
		this.numberofadults = numberofadults;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.status = status;
		this.numberofnights = numberofnights;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getNumberofchildren() {
		return numberofchildren;
	}

	public void setNumberofchildren(int numberofchildren) {
		this.numberofchildren = numberofchildren;
	}

	public int getNumberofadults() {
		return numberofadults;
	}

	public void setNumberofadults(int numberofadults) {
		this.numberofadults = numberofadults;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumberofnights() {
		return numberofnights;
	}

	public void setNumberofnights(int numberofnights) {
		this.numberofnights = numberofnights;
	}

	@Override
	public String toString() {
		return "Reservation [code=" + code + ", numberofchildren=" + numberofchildren + ", numberofadults="
				+ numberofadults + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", status="
				+ status + ", numberofnights=" + numberofnights + "]";
	}
	
	

}
