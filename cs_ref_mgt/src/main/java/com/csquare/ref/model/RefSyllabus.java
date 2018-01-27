package com.csquare.ref.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.csquare.framework.entity.PKGenerator;


@Entity
@Table(name = "ref_syllabus", schema = "ref_mgt")
@NamedQuery(name = "getAllRefSyllabus", query = NamedQueryConstants.getAllRefSyllabus)
public class RefSyllabus {
	
	@Id
    @Column(name = "pk")
	@GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
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
