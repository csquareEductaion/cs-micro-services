package com.csquare.lead.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LeadLocations", schema = "lead_mgt")

public class LeadLocations {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
    private String pk;
	
	@Column(name = "location_id")
    private String Locatlocation_idionId;

    @Column(name = "lead_id")
    private String lead_id;
    
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

	public String getLead_id() {
		return lead_id;
	}

	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}

	
	
	
}
