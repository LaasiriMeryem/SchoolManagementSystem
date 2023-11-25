package com.example.Studentmanagment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
public String firstName;
public String lastName;
public TypeModule module;
public String email;

	
   

	public Teacher(String firstName, String lastName, TypeModule module, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.module = module;
		this.email = email;
		
	}
	 public Teacher() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public TypeModule getModule() {
		return module;
	}

	public void setModule(TypeModule module) {
		this.module = module;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
	
	
	
	
}
