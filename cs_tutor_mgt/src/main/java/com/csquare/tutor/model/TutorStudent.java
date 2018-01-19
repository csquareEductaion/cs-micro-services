package com.csquare.tutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.csquare.framework.entity.PKGenerator;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "tutor", schema = "tutor_mgt")
public class TutorStudent {
	
	@Id
    @Column(name = "pk")
	@GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
    private String pk;

    @Column(name = "student_id")
    private String student_id;

    @Column(name = "tutor_id")
    private String tutor_id;

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getTutor_id() {
		return tutor_id;
	}

	public void setTutor_id(String tutor_id) {
		this.tutor_id = tutor_id;
	}
    
    

}
