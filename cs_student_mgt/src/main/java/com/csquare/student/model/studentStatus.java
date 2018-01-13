package com.csquare.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student_status", schema = "student_mgt")

public class studentStatus {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
    private String pk;
	
	@Column(name = "current_status")
    private String current_status;
	
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}

	

    

}
