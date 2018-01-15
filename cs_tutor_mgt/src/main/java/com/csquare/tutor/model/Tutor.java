package com.csquare.tutor.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "tutor", schema = "tutor_mgt")
public class Tutor {

    @Id
    @Column(name = "pk")
    private String pK;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private BigDecimal phone;

    @Column(name = "city")
    private String city;

    @Column(name = "comment")
    private String comment;

    @Column(name = "have_vechile")
    private String have_vechile;
    
    @Column(name = "experience_in_years")
    private String experience_in_years;
    
    @Column(name = "alternate_phone")
    private Float alternate_phone;
    
    @Column(name = "verified")
    private Boolean verified;
    
    @Column(name = "aadhar_verified")
    private Boolean aadhar_verified;
    
    @Column(name = "verify_without_aadhar")
    private Boolean verify_without_aadhar;
    
    @Column(name = "subm_higher_edu_doc")
    private Boolean subm_higher_edu_doc;
    
    @Column(name = "address")
    private String address;
    
    

     @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
     @JoinColumn(name = "tutor_id", referencedColumnName = "pk")
     private Set<TutorGrade> leadGradeList = new HashSet<TutorGrade>();

     @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
     @JoinColumn(name = "tutor_id", referencedColumnName = "pk")
     private Set<TutorLocation> leadLocationList = new HashSet<TutorLocation>();

     @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
     @JoinColumn(name = "tutor_id", referencedColumnName = "pk")
     private Set<TutorSubject> leadSubjectList = new HashSet<TutorSubject>();

     @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
     @JoinColumn(name = "tutor_id", referencedColumnName = "pk")
     private Set<TutorSyllabus> leadSyllabusList = new HashSet<TutorSyllabus>();

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

	public BigDecimal getPhone() {
		return phone;
	}

	public void setPhone(BigDecimal phone) {
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

	public String getHave_vechile() {
		return have_vechile;
	}

	public void setHave_vechile(String have_vechile) {
		this.have_vechile = have_vechile;
	}

	public String getExperience_in_years() {
		return experience_in_years;
	}

	public void setExperience_in_years(String experience_in_years) {
		this.experience_in_years = experience_in_years;
	}

	public Float getAlternate_phone() {
		return alternate_phone;
	}

	public void setAlternate_phone(Float alternate_phone) {
		this.alternate_phone = alternate_phone;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Boolean getAadhar_verified() {
		return aadhar_verified;
	}

	public void setAadhar_verified(Boolean aadhar_verified) {
		this.aadhar_verified = aadhar_verified;
	}

	public Boolean getVerify_without_aadhar() {
		return verify_without_aadhar;
	}

	public void setVerify_without_aadhar(Boolean verify_without_aadhar) {
		this.verify_without_aadhar = verify_without_aadhar;
	}

	public Boolean getSubm_higher_edu_doc() {
		return subm_higher_edu_doc;
	}

	public void setSubm_higher_edu_doc(Boolean subm_higher_edu_doc) {
		this.subm_higher_edu_doc = subm_higher_edu_doc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
    


    
}
