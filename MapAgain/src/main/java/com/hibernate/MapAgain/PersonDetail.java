package com.hibernate.MapAgain;

import java.util.AbstractCollection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonDetail {
	
	@Id
	@GeneratedValue
	@Column(name="detailId_PK")
	private Integer personDetailId;
	private String zipCode;
	private String job;
	private double income;
	
	
	public Integer getPersonDetailId() {
		return personDetailId;
	}
	public void setPersonDetailId(Integer personDetailId) {
		this.personDetailId = personDetailId;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	
	

}
