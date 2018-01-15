package com.csquare.tutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "tutor_grade", schema = "tutor_mgt")

public class TutorGrade {

    @Id
    @Column(name = "pk")
    private String pk;

    @Column(name = "grade_id")
    private String gradeId;

    @Column(name = "tutor_id")
    private String tutor_Id;

    public String getPk() {

        return pk;
    }

    public void setPk(String pk) {

        this.pk = pk;
    }

    public String getGradeId() {

        return gradeId;
    }

    public void setGradeId(String gradeId) {

        this.gradeId = gradeId;
    }

	public String getTutor_Id() {
		return tutor_Id;
	}

	public void setTutor_Id(String tutor_Id) {
		this.tutor_Id = tutor_Id;
	}

   
}
