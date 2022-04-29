package com.abhisheksah.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Staff")
public class Staff {

	@Id
	private int id;
	@Field
	private String employeeName;
	private String employeeAddress;
	private String employeeEmail;
	private String employeeGender;
	private String employeePost;
	private long employeeSalary;
	
	public Staff() {
		super();
	
	}
	
	public Staff(int id, String employeeName, String employeeAddress, String employeeEmail, String employeeGender,
			String employeePost, long employeeSalary) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeEmail = employeeEmail;
		this.employeeGender = employeeGender;
		this.employeePost = employeePost;
		this.employeeSalary = employeeSalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeePost() {
		return employeePost;
	}

	public void setEmployeePost(String employeePost) {
		this.employeePost = employeePost;
	}

	public long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + id + ", employeeName=" + employeeName + ", employeeAddress=" + employeeAddress
				+ ", employeeEmail=" + employeeEmail + ", employeeGender=" + employeeGender + ", EmployeePost="
				+ employeePost + ", employeeSalary=" + employeeSalary + "]";
	}


	
}
