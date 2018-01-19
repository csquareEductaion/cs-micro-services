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
@Table(name = "student_locations", schema = "student_mgt")

public class studentLocations {
	
	@Id
    @Column(name = "pk")
	@GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
    private String pk;
	
	@Column(name = "location_id")
    private String Locatlocation_idionId;

    @Column(name = "student_id")
    private String student_id;
    
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getLocatlocation_idionId() {
		return Locatlocation_idionId;
	}

	public void setLocatlocation_idionId(String locatlocation_idionId) {
		Locatlocation_idionId = locatlocation_idionId;
	}

	public String getstudent_id() {
		return student_id;
	}

	public void setstudent_id(String student_id) {
		this.student_id = student_id;
	}

	
	
	
}
