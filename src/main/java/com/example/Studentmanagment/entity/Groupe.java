package com.example.Studentmanagment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.criteria.Fetch;


@Entity
public class Groupe {
	@Id
 public TypeGroupes name;
 public int capacity;
 public String teacher;
public Groupe( TypeGroupes name, int capacity, String teacher) {
	super();
	this.name = name;
	this.capacity = capacity;
	this.teacher=teacher;
}
public Groupe() {
	super();
}
public TypeGroupes getName() {
	return name;
}
public void setName(TypeGroupes name) {
	this.name = name;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public String getTeacher() {
	return teacher;
}
public void setTeacher(String teacher) {
	this.teacher = teacher;
}
 

 
 
}
