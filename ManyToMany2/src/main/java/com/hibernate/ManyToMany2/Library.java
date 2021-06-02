package com.hibernate.ManyToMany2;



import java.util.List;  
  
import javax.persistence.*;  
  
@Entity  
@Table(name="Library")  
public class Library {  
@Id  
@GeneratedValue(strategy=GenerationType.AUTO)  
private int b_id;  
private String b_name;  
  
@ManyToMany(targetEntity=Student.class)  
private List stud;  
  
  
  
  
public Library(int b_id, String b_name, List stud) {  
    super();  
    this.b_id = b_id;  
    this.b_name = b_name;  
    this.stud = stud;  
}  
  
public Library() {  
    super();  
    // TODO Auto-generated constructor stub  
}  
  
public int getB_id() {  
    return b_id;  
}  
  
public void ListB_id(int b_id) {  
    this.b_id = b_id;  
}  
  
public String getB_name() {  
    return b_name;  
}  
  
public void ListB_name(String b_name) {  
    this.b_name = b_name;  
}  
  
public List getStud() {  
    return stud;  
}  
  
public void ListStud(List stud) {  
    this.stud = stud;  
}  
  
      
}  