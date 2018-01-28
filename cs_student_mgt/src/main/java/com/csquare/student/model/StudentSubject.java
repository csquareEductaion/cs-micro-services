package com.csquare.student.model;

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
@Table(name = "student_subject", schema = "student_mgt")
public class StudentSubject {

    @Id
    @Column(name = "pk")
    @GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
    private String pk;

    @Column(name = "subject_id")
    private String subjectId;

    @Column(name = "student_id")
    private String studentId;

    public String getPk() {

        return pk;
    }

    public void setPk(String pk) {

        this.pk = pk;
    }

    public String getSubjectId() {

        return subjectId;
    }

    public void setSubjectId(String subjectId) {

        this.subjectId = subjectId;
    }

    public String getStudentId() {

        return studentId;
    }

    public void setStudentId(String studentId) {

        this.studentId = studentId;
    }

}
