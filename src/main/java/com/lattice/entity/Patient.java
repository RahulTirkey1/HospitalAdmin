package com.lattice.entity;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	
	@NotNull
	@Size(min=3)
	private String name;
	
	@Size(min=10)
	private String address;
	
	@Id
	@NotEmpty
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	
	@Pattern(regexp="^[1-9][0-9]{10,13}$")
	@NotEmpty
	private String phoneNo;
	
//	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
	@NotEmpty
	private String password;
	
	private Date creationdate;
	private Date bookingDate;
	private Boolean booking;
	
	private String role;
	
	public Patient() {
		
	}

	public Patient(String name,String address,
				String email,
			String phoneNo, String password, Date creationdate,
			Date bookingDate, Boolean booking, String role) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.creationdate = creationdate;
		this.bookingDate = bookingDate;
		this.booking = booking;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Boolean getBooking() {
		return booking;
	}

	public void setBooking(Boolean booking) {
		this.booking = booking;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
