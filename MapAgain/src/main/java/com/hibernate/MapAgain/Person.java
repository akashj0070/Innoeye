package com.hibernate.MapAgain;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Person {
	
	private Integer personId;
	private String personName;
	
	private PersonDetail personDetail;
	//persondetails with person is also loaded using eager
	//cascadetype shows which operations to do
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="personDetail_FK")
	public PersonDetail getPersonDetail() {
		return personDetail;
	}
	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}
	@Id
	@GeneratedValue
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
}
