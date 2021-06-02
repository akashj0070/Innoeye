package com.hibernate.HibernateExample;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EmpAccount {
	@Column
	private Integer AccountNumber;
	@Column
	private String AccountHolderName;
	@javax.persistence.Id
	@Column
	private Integer Id;
	
	public Integer getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public void setAccountHolderName(String acoountHolderName) {
		AccountHolderName = acoountHolderName;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	@JoinColumn(name="Id")
	@OneToOne(cascade = CascadeType.ALL)
	private Employees employees;
	
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	
}
