package com.bootcrud.config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public Employee(int id, String firstname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.email = email;
	}

	@Column(name="first_name")
	private String firstname;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="email")
	private String email;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
}
