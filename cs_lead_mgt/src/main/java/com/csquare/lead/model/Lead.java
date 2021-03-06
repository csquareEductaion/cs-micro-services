package com.csquare.lead.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.csquare.framework.entity.PKGenerator;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "lead", schema = "lead_mgt")
@NamedQuery(name = "getAllLead", query = NamedQueryConstants.getAllLead)
public class Lead {

    @Id
    @Column(name = "pk")
    @GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
    private String pK;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "location")
    private String location;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "city")
    private String city;

    @Column(name = "comment")
    private String comment;

    @Column(name = "istutor")
    private Boolean istutor;

    @Column(name = "isstudent")
    private Boolean isstudent;

    @Column(name = "lead_status")
    private String leadStatus;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "alternate_phone")
    private String alteratePhone;
    
    @Column(name = "qualification")
    private String qualification;

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "lead_id", referencedColumnName = "pk")
    @Fetch(FetchMode.JOIN)
    private Set<LeadGrade> leadGradeList = new LinkedHashSet<LeadGrade>();

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "lead_id", referencedColumnName = "pk")
    @Fetch(FetchMode.JOIN)
    private Set<LeadLocation> leadLocationList = new LinkedHashSet<LeadLocation>();

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "lead_id", referencedColumnName = "pk")
    @Fetch(FetchMode.JOIN)
    private Set<LeadSubject> leadSubjectList = new LinkedHashSet<LeadSubject>();

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "lead_id", referencedColumnName = "pk")
    @Fetch(FetchMode.JOIN)
    private Set<LeadSyllabus> leadSyllabusList = new LinkedHashSet<LeadSyllabus>();

    public String getpK() {

        return pK;
    }

    public void setpK(String pK) {

        this.pK = pK;
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

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getComment() {

        return comment;
    }

    public void setComment(String comment) {

        this.comment = comment;
    }

    public String getLeadStatus() {

        return leadStatus;
    }

    public void setLeadStatus(String leadStatus) {

        this.leadStatus = leadStatus;
    }

    public Set<LeadGrade> getLeadGradeList() {

        return leadGradeList;
    }

    public void setLeadGradeList(Set<LeadGrade> leadGradeList) {

        this.leadGradeList = leadGradeList;
    }

    public Set<LeadLocation> getLeadLocationList() {

        return leadLocationList;
    }

    public void setLeadLocationList(Set<LeadLocation> leadLocationList) {

        this.leadLocationList = leadLocationList;
    }

    public Set<LeadSubject> getLeadSubjectList() {

        return leadSubjectList;
    }

    public void setLeadSubjectList(Set<LeadSubject> leadSubjectList) {

        this.leadSubjectList = leadSubjectList;
    }

    public Set<LeadSyllabus> getLeadSyllabusList() {

        return leadSyllabusList;
    }

    public void setLeadSyllabusList(Set<LeadSyllabus> leadSyllabusList) {

        this.leadSyllabusList = leadSyllabusList;
    }

    public Boolean getIstutor() {

        return istutor;
    }

    public void setIstutor(Boolean istutor) {

        this.istutor = istutor;
    }

    public Boolean getIsstudent() {

        return isstudent;
    }

    public void setIsstudent(Boolean isstudent) {

        this.isstudent = isstudent;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getAlteratePhone() {

        return alteratePhone;
    }

    public void setAlteratePhone(String alteratePhone) {

        this.alteratePhone = alteratePhone;
    }

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

    
    
}
