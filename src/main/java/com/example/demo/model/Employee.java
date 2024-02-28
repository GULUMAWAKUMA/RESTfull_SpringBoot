package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "User_name", nullable = false)
	private String userName;
	
	@Column(name= "first_name", nullable = false)
	private String firstName;
	
	@Column(name= "last_name", nullable = false)
	private String lastName;
	
	@Column(name= "password", nullable = false)
	private String password;

	@Column(name= "email", nullable = false)
	private String email;

	@Column(name= "gender", nullable = false)
	private String gender;
	@Column(name= "role", nullable = false)
	private String role;
	@Column(name= "isactive", nullable = false)
	private Boolean isactive;
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
	
	
}
