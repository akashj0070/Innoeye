package com.springboot.web;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentModel {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
@Column
private String name;
@Column
private Integer marks;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getMarks() {
	return marks;
}

public void setMarks(Integer marks) {
	this.marks = marks;
}

@Override
public String toString() {
	return "StudentModel [id=" + id + ", name=" + name + ", marks=" + marks + "]";
}

public Iterable<StudentModel> findAll() {
	// TODO Auto-generated method stub
	return null;
}


  
}
 
