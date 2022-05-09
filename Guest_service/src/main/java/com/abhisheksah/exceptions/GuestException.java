package com.abhisheksah.exceptions;

public class GuestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GuestException(String message) {
		super(message);
	}
	public static String NotFoundException(String id) {
		return "Guest with "+id+ " not Found";
	}
	public static String GuestAlreadyExist() {
		return "Guest with given name already exists";
	}

}
