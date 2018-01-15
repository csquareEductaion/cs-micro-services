package com.csquare.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ref_user_role", schema = "user_mgt")

public class UserRole {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
    private String pk;
	
	@Column(name = "role_name")
    private String role_name;

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

    
}