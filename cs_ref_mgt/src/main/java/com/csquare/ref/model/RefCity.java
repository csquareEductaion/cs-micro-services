package com.csquare.ref.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ref_city", schema = "ref_mgt")
public class RefCity {

    @Id
    @Column(name = "pk")
    private String pK;

    @Column(name = "city_name")
    private String city_name;

    @Column(name = "city_code")
    private String city_code;
    
    public String getpK() {
		return pK;
	}

	public void setpK(String pK) {
		this.pK = pK;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	

    
}
