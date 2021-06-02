
package com.springjpa.test;

public class StudentModel {

private String name;
private String language;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
@Override
public String toString() {
	return "StudentModel [name=" + name + ", language=" + language + "]";
}

  
  }
 
