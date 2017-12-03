package com.csquare.ums.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "public")
public class Student extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentid")
	private long studentid;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	//Dropdown
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "comment")
	private String comment;

	//Dropdown 
	@Column(name = "gender")
	private String gender;
	
	//Dropdown
	@Column(name = "city")
	private String city;
	
	//Dropdown and multiselect
	@Column(name = "syllabus")
	private String syllabus;
		
	//Dropdown
	@Column(name = "subjects")
	private String subjects;	
	
	//Dropdown
	@Column(name = "address")
	private String address;

	public long getStudentid() {
		return studentid;
	}


	public void setStudentid(long studentid) {
		this.studentid = studentid;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getSyllabus() {
		return syllabus;
	}


	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}


	public String getSubjects() {
		return subjects;
	}


	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	

	
	
	

}
