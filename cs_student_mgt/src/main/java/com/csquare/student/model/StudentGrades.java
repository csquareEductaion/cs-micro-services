package com.csquare.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "lead_grades", schema = "lead_mgt")


public class StudentGrades {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
    private String pk;
	
	@Column(name = "grade_id")
    private String grade_id;

    @Column(name = "lead_id")
    private String lead_id;
	
	
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(String grade_id) {
		this.grade_id = grade_id;
	}

	public String getLead_id() {
		return lead_id;
	}

	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}

	
	

	
    
    
}
