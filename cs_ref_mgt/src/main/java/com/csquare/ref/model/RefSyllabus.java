package com.csquare.ref.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ref_syllabus", schema = "ref_mgt")

public class RefSyllabus {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
    private String pk;
	
	@Column(name = "syllabus_name")
    private String syllabus_name;
   
	
	public String getSyllabus_name() {
		return syllabus_name;
	}

	public void setSyllabus_name(String syllabus_name) {
		this.syllabus_name = syllabus_name;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	
	

}
