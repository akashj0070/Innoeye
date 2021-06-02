package com.hibernate.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;
@Entity
public class College {
	@Id
	@GeneratedValue
	private Integer collegeId;
	private String collegeName;
	
	@OneToMany(mappedBy = "college" , fetch = FetchType.LAZY)
	@ElementCollection(targetClass =Students.class)
	private List<Students> students;
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	@OneToMany(targetEntity = Students.class , mappedBy = "college",
			cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	

}
