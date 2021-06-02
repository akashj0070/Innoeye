package com.hibernate.HibernateExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employees {
	@javax.persistence.Id
	@Column(name="id")
	private Integer Id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	
	@OneToOne(mappedBy = "empAccount")
//	@JoinColumn(name="Id")
	private EmpAccount empAccount;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	public EmpAccount getEmpAccount() {
		return empAccount;
	}
	public void setEmpAccount(EmpAccount empAccount) {
		this.empAccount = empAccount;
	}
	
	
	
}
