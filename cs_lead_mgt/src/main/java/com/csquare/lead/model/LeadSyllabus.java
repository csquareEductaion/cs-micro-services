package com.csquare.lead.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "lead_syllabus", schema = "lead_mgt")

public class LeadSyllabus {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
    private String pk;

    @Column(name = "syllabus_id")
    private String syllabusId;

    @Column(name = "lead_id")
    private String leadId;

    public String getPk() {

        return pk;
    }

    public void setPk(String pk) {

        this.pk = pk;
    }

    public String getSyllabusId() {

        return syllabusId;
    }

    public void setSyllabusId(String syllabusId) {

        this.syllabusId = syllabusId;
    }

    public String getLeadId() {

        return leadId;
    }

    public void setLeadId(String leadId) {

        this.leadId = leadId;
    }

}
