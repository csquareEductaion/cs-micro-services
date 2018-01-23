package com.csquare.student.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.csquare.framework.entity.PKGenerator;


@Entity
@Table(name = "student", schema = "student_mgt")
public class Student {

    @Id
    @Column(name = "pk")
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
    private Float phone;
    
    @Column(name = "city")
    private String city;


    @Column(name = "comment")
    private String comment;

    @Column(name = "lead_status")
    private String leasStatus;
    
    @Column(name = "Gender")
    private String gender;
    
    @Column(name = "parent_name")
    private String parentName;
    
    @Column(name = "existing_client")
    private String existingClient;
    
    @Column(name = "source_of_lead")
    private String sourceOfLead;
    
    @Column(name = "is_hold")
    private String isHold;
    
    @Column(name = "student_record_owner")
    private String studentRecordOwner;
    
    @Column(name = "is_parent_doc_submitted")
    private String parentsDocStatus;
    
    @Column(name = "is_tutor_doc_submitted")
    private String tutorDocStatus;
    
    @Column(name = "is_intrested")
    private String interested;
    
    @Column(name = "is_not_interested")
    private String notInterested;
    
    @Column(name = "is_demo_required")
    private String demoRequired;
    
    @Column(name = "demo_date")
    private String demoDate;
    
    @Column(name = "is_converted")
    private String converted;
    
    @Column(name = "enrollment_date")
    private String enrollmentDate;
    
    @Column(name = "is_followup_required")
    private String requiredFollowUp;
    
    @Column(name = "next_followup_date")
    private String followUpDate;
    
    @Column(name = "preffered_call_time")
    private String callPreferredTime;
    
    @Column(name = "is_conversion_pending")
    private String pendingForConversion;
    
    @Column(name = "is_home_tuition_stop")
    private String isStopped;
    
    @Column(name = "class_stop_date")
    private String stoppedDate;
        
    @Column(name = "is_agreement_sent_to_parent")
    private String parentAgreementStatus;
    
    @Column(name = "is_agreemenet_sent_to_tutor")
    private String tutorAgreementStatus;
    
    @Column(name = "package_in_hrs")
    private String packageInHrs;
    
    @Column(name = "hourly_rate")
    private String hourlyRate;
    
    @Column(name = "registration_fee_amount")
    private String registrationFee;
    
    @Column(name = "is_registration_paid")
    private String isRegistrationPaid;
    
    @Column(name = "total_tuition_fee")
    private String studentTotalFee;
    
    @Column(name = "csquare_income")
    private String csquareIncome;
    
   @Column(name = "tuition_required_for_months")
   private String tutionRequiredForMonths;

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

	public Float getPhone() {
		return phone;
	}

	public void setPhone(Float phone) {
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

	public String getLeasStatus() {
		return leasStatus;
	}

	public void setLeasStatus(String leasStatus) {
		this.leasStatus = leasStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getExistingClient() {
		return existingClient;
	}

	public void setExistingClient(String existingClient) {
		this.existingClient = existingClient;
	}

	public String getSourceOfLead() {
		return sourceOfLead;
	}

	public void setSourceOfLead(String sourceOfLead) {
		this.sourceOfLead = sourceOfLead;
	}

	public String getIsHold() {
		return isHold;
	}

	public void setIsHold(String isHold) {
		this.isHold = isHold;
	}

	public String getStudentRecordOwner() {
		return studentRecordOwner;
	}

	public void setStudentRecordOwner(String studentRecordOwner) {
		this.studentRecordOwner = studentRecordOwner;
	}

	public String getParentsDocStatus() {
		return parentsDocStatus;
	}

	public void setParentsDocStatus(String parentsDocStatus) {
		this.parentsDocStatus = parentsDocStatus;
	}

	public String getTutorDocStatus() {
		return tutorDocStatus;
	}

	public void setTutorDocStatus(String tutorDocStatus) {
		this.tutorDocStatus = tutorDocStatus;
	}

	public String getInterested() {
		return interested;
	}

	public void setInterested(String interested) {
		this.interested = interested;
	}

	public String getNotInterested() {
		return notInterested;
	}

	public void setNotInterested(String notInterested) {
		this.notInterested = notInterested;
	}

	public String getDemoRequired() {
		return demoRequired;
	}

	public void setDemoRequired(String demoRequired) {
		this.demoRequired = demoRequired;
	}

	public String getDemoDate() {
		return demoDate;
	}

	public void setDemoDate(String demoDate) {
		this.demoDate = demoDate;
	}

	public String getConverted() {
		return converted;
	}

	public void setConverted(String converted) {
		this.converted = converted;
	}

	public String getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getRequiredFollowUp() {
		return requiredFollowUp;
	}

	public void setRequiredFollowUp(String requiredFollowUp) {
		this.requiredFollowUp = requiredFollowUp;
	}

	public String getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(String followUpDate) {
		this.followUpDate = followUpDate;
	}

	public String getCallPreferredTime() {
		return callPreferredTime;
	}

	public void setCallPreferredTime(String callPreferredTime) {
		this.callPreferredTime = callPreferredTime;
	}

	public String getPendingForConversion() {
		return pendingForConversion;
	}

	public void setPendingForConversion(String pendingForConversion) {
		this.pendingForConversion = pendingForConversion;
	}

	public String getIsStopped() {
		return isStopped;
	}

	public void setIsStopped(String isStopped) {
		this.isStopped = isStopped;
	}

	public String getStoppedDate() {
		return stoppedDate;
	}

	public void setStoppedDate(String stoppedDate) {
		this.stoppedDate = stoppedDate;
	}

	public String getParentAgreementStatus() {
		return parentAgreementStatus;
	}

	public void setParentAgreementStatus(String parentAgreementStatus) {
		this.parentAgreementStatus = parentAgreementStatus;
	}

	public String getTutorAgreementStatus() {
		return tutorAgreementStatus;
	}

	public void setTutorAgreementStatus(String tutorAgreementStatus) {
		this.tutorAgreementStatus = tutorAgreementStatus;
	}

	public String getPackageInHrs() {
		return packageInHrs;
	}

	public void setPackageInHrs(String packageInHrs) {
		this.packageInHrs = packageInHrs;
	}

	public String getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(String hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(String registrationFee) {
		this.registrationFee = registrationFee;
	}

	public String getIsRegistrationPaid() {
		return isRegistrationPaid;
	}

	public void setIsRegistrationPaid(String isRegistrationPaid) {
		this.isRegistrationPaid = isRegistrationPaid;
	}

	public String getStudentTotalFee() {
		return studentTotalFee;
	}

	public void setStudentTotalFee(String studentTotalFee) {
		this.studentTotalFee = studentTotalFee;
	}

	public String getCsquareIncome() {
		return csquareIncome;
	}

	public void setCsquareIncome(String csquareIncome) {
		this.csquareIncome = csquareIncome;
	}

	public String getTutionRequiredForMonths() {
		return tutionRequiredForMonths;
	}

	public void setTutionRequiredForMonths(String tutionRequiredForMonths) {
		this.tutionRequiredForMonths = tutionRequiredForMonths;
	}

	
	
	
}
