package com.bootcrud;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "basics")
public class UserDetails {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String occupation;
	@Column
	private String hobby;
	@Column
	private String roles;

	@Column
	private String password;
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetails{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", occupation='" + occupation + '\'' +
				", hobby='" + hobby + '\'' +
				", roles='" + roles + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	public UserDetails(int id, String name, int age, String occupation, String hobby, String password, String roles) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.occupation = occupation;
		this.hobby = hobby;
		this.password = password;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
