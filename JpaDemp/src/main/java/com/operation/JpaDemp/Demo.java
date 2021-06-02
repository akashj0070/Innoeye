package com.operation.JpaDemp;

public class Demo {
	private int id;
	private String Name;
	private String Tech;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "Demo [id=" + id + ", Name=" + Name + ", Tech=" + Tech + "]";
	}
	
}
