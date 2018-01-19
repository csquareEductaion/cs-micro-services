package com.csquare.lead.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.csquare.framework.entity.PKGenerator;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "lead_grade", schema = "lead_mgt")

public class LeadGrade {

    @Id
    @Column(name = "pk")
    @GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
    private String pk;

    @Column(name = "grade_id")
    private String gradeId;

    @Column(name = "lead_id")
    private String leadId;

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

    public String getLeadId() {

        return leadId;
    }

    public void setLeadId(String leadId) {

        this.leadId = leadId;
    }

}
