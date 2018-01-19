package com.csquare.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.csquare.framework.entity.PKGenerator;


@Entity
@Table(name = "student_subjects", schema = "student_mgt")

public class StudentSubjects {

	@Id
    @Column(name = "pk")
	@GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
    private String pk;
	
	@Column(name = "subject_id")
    private String subject_id;

    @Column(name = "student_id")
    private String student_id;
	
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public String getstudent_id() {
		return student_id;
	}

	public void setstudent_id(String student_id) {
		this.student_id = student_id;
	}

	
	
    
	
}
