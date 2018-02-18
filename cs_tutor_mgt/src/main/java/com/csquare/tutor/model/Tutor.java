package com.csquare.tutor.model;

import java.math.BigDecimal;
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
@Table(name = "tutor", schema = "tutor_mgt")
public class Tutor {

    @Id
    @Column(name = "tutor_id")
    @GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
    private String pK;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "city")
    private String city;

    @Column(name = "comment")
    private String comment;

    @Column(name = "have_vechile")
    private String have_vechile;

    @Column(name = "experience_in_years")
    private String experience_in_years;

    @Column(name = "alternate_phone")
    private String alternate_phone;

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

    @Column(name = "gender")
    private String gender;
    
    @Column(name = "location")
    private String location;

    @Column(name = "is_phone_dnd")
    private String is_phone_dnd;

    @Column(name = "is_trusted_tutor")
    private Boolean is_trusted_tutor;

    @Column(name = "is_interested_for_home_tuition")
    private Boolean is_interested_for_home_tuition;

    @Column(name = "qualification")
    private String qualification;
    
    @Column(name = "follo_up_required")
    private Boolean followUpRequired;
    
    @Column(name = "interview_date")
    private String interviewDate;
    
    @Column(name = "interview_time")
    private String interviewTime;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "round_cleared")
    private String roundCleared;
    
    @Column(name = "preffered_timing")
    private String prefferedTiming;
    
    @Column(name = "preffered_days")
    private String prefferedDays;
    
    @Column(name = "grade")
    private String grade;
    
   
    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    @Fetch(FetchMode.JOIN)
    private Set<TutorGrade> tutorGradeList = new LinkedHashSet<TutorGrade>();

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    @Fetch(FetchMode.JOIN)
    private Set<TutorLocation> tutorLocationList = new LinkedHashSet<TutorLocation>();

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    @Fetch(FetchMode.JOIN)
    private Set<TutorSubject> tutorSubjectList = new LinkedHashSet<TutorSubject>();

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    @Fetch(FetchMode.JOIN)
    private Set<TutorSyllabus> tutorSyllabusList = new LinkedHashSet<TutorSyllabus>();
    
    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    @Fetch(FetchMode.JOIN)
    private Set<TutorStudent> tutorStudentList = new LinkedHashSet<TutorStudent>();
    
    
    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    @Fetch(FetchMode.JOIN)
    private Set<TutorHigherEdu> tutorHigerEduList = new LinkedHashSet<TutorHigherEdu>();
    
   

   
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

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public String getIs_phone_dnd() {

        return is_phone_dnd;
    }

    public void setIs_phone_dnd(String is_phone_dnd) {

        this.is_phone_dnd = is_phone_dnd;
    }

    public Boolean getIs_trusted_tutor() {
		return is_trusted_tutor;
	}

	public void setIs_trusted_tutor(Boolean is_trusted_tutor) {
		this.is_trusted_tutor = is_trusted_tutor;
	}

	public Boolean getIs_interested_for_home_tuition() {
		return is_interested_for_home_tuition;
	}

	public void setIs_interested_for_home_tuition(Boolean is_interested_for_home_tuition) {
		this.is_interested_for_home_tuition = is_interested_for_home_tuition;
	}

	public String getQualification() {

        return qualification;
    }

    public void setQualification(String qualification) {

        this.qualification = qualification;
    }

	public Set<TutorGrade> getTutorGradeList() {
		return tutorGradeList;
	}

	public void setTutorGradeList(Set<TutorGrade> tutorGradeList) {
		this.tutorGradeList = tutorGradeList;
	}

	public Set<TutorLocation> getTutorLocationList() {
		return tutorLocationList;
	}

	public void setTutorLocationList(Set<TutorLocation> tutorLocationList) {
		this.tutorLocationList = tutorLocationList;
	}

	public Set<TutorSubject> getTutorSubjectList() {
		return tutorSubjectList;
	}

	public void setTutorSubjectList(Set<TutorSubject> tutorSubjectList) {
		this.tutorSubjectList = tutorSubjectList;
	}

	public Set<TutorSyllabus> getTutorSyllabusList() {
		return tutorSyllabusList;
	}

	public void setTutorSyllabusList(Set<TutorSyllabus> tutorSyllabusList) {
		this.tutorSyllabusList = tutorSyllabusList;
	}

	public Set<TutorStudent> getTutorStudentList() {
		return tutorStudentList;
	}

	public void setTutorStudentList(Set<TutorStudent> tutorStudentList) {
		this.tutorStudentList = tutorStudentList;
	}

	public Set<TutorHigherEdu> getTutorHigerEduList() {
		return tutorHigerEduList;
	}

	public void setTutorHigerEduList(Set<TutorHigherEdu> tutorHigerEduList) {
		this.tutorHigerEduList = tutorHigerEduList;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getFollowUpRequired() {
		return followUpRequired;
	}

	public void setFollowUpRequired(Boolean followUpRequired) {
		this.followUpRequired = followUpRequired;
	}

	public String getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(String interviewTime) {
		this.interviewTime = interviewTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRoundCleared() {
		return roundCleared;
	}

	public void setRoundCleared(String roundCleared) {
		this.roundCleared = roundCleared;
	}

	public String getPrefferedTiming() {
		return prefferedTiming;
	}

	public void setPrefferedTiming(String prefferedTiming) {
		this.prefferedTiming = prefferedTiming;
	}

	public String getPrefferedDays() {
		return prefferedDays;
	}

	public void setPrefferedDays(String prefferedDays) {
		this.prefferedDays = prefferedDays;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAlternate_phone() {
		return alternate_phone;
	}

	public void setAlternate_phone(String alternate_phone) {
		this.alternate_phone = alternate_phone;
	}
    
    

}
