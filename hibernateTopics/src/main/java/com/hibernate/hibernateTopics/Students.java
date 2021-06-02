package com.hibernate.hibernateTopics;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@NamedQueries(
		{
			@NamedQuery(
					name="findbyname",
					query="from Students s where s.stud_name = :name")
		})

@Entity
@Table(name="students")
@Cacheable  
@Cache(usage=CacheConcurrencyStrategy.NONE)  
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer stud_id;
	@Column(name="Name")
	private String stud_name;
	@Column(name="Subject")
	private String stud_subject;
	public Integer getStud_id() {
		return stud_id;
	}
	public void setStud_id(Integer stud_id) {
		this.stud_id = stud_id;
	}
	public String getStud_name() {
		return stud_name;
	}
	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}
	public String getStud_subject() {
		return stud_subject;
	}
	public void setStud_subject(String stud_subject) {
		this.stud_subject = stud_subject;
	}
	@Override
	public String toString() {
		return "Students [stud_id=" + stud_id + ", stud_name=" + stud_name + ", stud_subject=" + stud_subject + "]";
	}
	
}
