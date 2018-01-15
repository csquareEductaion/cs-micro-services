package com.csquare.tutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "tutor", schema = "tutor_mgt")
public class TutorHigherEdu {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
    private String pk;

    @Column(name = "higher_education")
    private String higher_education;

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getHigher_education() {
		return higher_education;
	}

	public void setHigher_education(String higher_education) {
		this.higher_education = higher_education;
	}

    
}
