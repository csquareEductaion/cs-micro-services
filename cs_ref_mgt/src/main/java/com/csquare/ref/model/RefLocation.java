package com.csquare.ref.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ref_location", schema = "ref_mgt")


public class RefLocation {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
    private String pk;
	
	@Column(name = "location_id")
    private String location_id;

    @Column(name = "location_code")
    private String location_code;
	
	
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getLocation_code() {
		return location_code;
	}

	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}

	
	

	
    
    
}
