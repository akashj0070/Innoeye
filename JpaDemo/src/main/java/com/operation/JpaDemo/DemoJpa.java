package com.operation.JpaDemo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class DemoJpa {
	
	private String Name;
	private String Tech;
	
	@Id 
	private int Id;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTech() {
		return Tech;
	}
	public void setTech(String tech) {
		Tech = tech;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "DemoJpa [Name=" + Name + ", Tech=" + Tech + ", Id=" + Id + "]";
	}
	
}
