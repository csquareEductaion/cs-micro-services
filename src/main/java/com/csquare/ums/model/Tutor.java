package com.csquare.ums.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tutor", schema = "public")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tutorid")
    private long tutorid;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    // Dropdown
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tutor")
    @Column(name = "grade")
    private List<Grades> grade;

    @Column(name = "comment")
    private String comment;

    // Dropdown
    @Column(name = "gender")
    private String gender;

    // Dropdown
    @Column(name = "city")
    private String city;

    // Dropdown and multiselect
    @Column(name = "syllabus")
    private String syllabus;

    // Dropdown and multiselect
    @Column(name = "subjects")
    private String subjects;

    @Column(name = "address")
    private String address;

    public long getTutorid() {

        return tutorid;
    }

    public void setTutorid(long tutorid) {

        this.tutorid = tutorid;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public List<Grades> getGrade() {

        return grade;
    }

    public void setGrade(List<Grades> grade) {

        this.grade = grade;
    }

    public String getComment() {

        return comment;
    }

    public void setComment(String comment) {

        this.comment = comment;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getSyllabus() {

        return syllabus;
    }

    public void setSyllabus(String syllabus) {

        this.syllabus = syllabus;
    }

    public String getSubjects() {

        return subjects;
    }

    public void setSubjects(String subjects) {

        this.subjects = subjects;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

}
