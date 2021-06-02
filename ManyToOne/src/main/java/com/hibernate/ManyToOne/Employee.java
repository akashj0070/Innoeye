package com.hibernate.ManyToOne;
import javax.persistence.*;  

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findEmployeeByName",  
	        query = "from Employee e where e.name = :name"  
	        )  
	    }  
	)  
@Entity  
@Table(name="emp107")  
public class Employee {    
@Id  
@GeneratedValue(strategy=GenerationType.AUTO)    
private int employeeId;    
private String name,email;    
public int getEmployeeId() {  
    return employeeId;  
}  
public void setEmployeeId(int employeeId) {  
    this.employeeId = employeeId;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public String getEmail() {  
    return email;  
}  
public void setEmail(String email) {  
    this.email = email;  
}  
@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)  
private Address address;  
public Address getAddress() {  
    return address;  
}  
public void setAddress(Address address) {  
    this.address = address;  
}    
}  