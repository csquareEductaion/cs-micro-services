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
    private String parent_name;
    
    @Column(name = "existing_client")
    private String existing_client;
    
    @Column(name = "source_of_lead")
    private String source_of_lead;
    
    @Column(name = "is_hold")
    private String is_hold;
    
    @Column(name = "student_record_owner")
    private String student_record_owner;
    
    @Column(name = "is_parent_doc_submitted")
    private String is_parent_doc_submitted;
    
    @Column(name = "is_intrested")
    private String is_intrested;
    
    @Column(name = "is_not_interested")
    private String is_not_interested;
    
    @Column(name = "is_demo_required")
    private String is_demo_required;
    
    @Column(name = "demo_date")
    private String demo_date;
    
    @Column(name = "is_converted")
    private String is_converted;
    
    @Column(name = "enrollment_date")
    private String enrollment_date;
    
    @Column(name = "is_followup_required")
    private String is_followup_required;
    
    @Column(name = "next_followup_date")
    private String next_followup_date;
    
    @Column(name = "preffered_call_time")
    private String preffered_call_time;
    
    @Column(name = "is_conversion_pending")
    private String is_conversion_pending;
    
    @Column(name = "is_home_tuition_stop")
    private String is_home_tuition_stop;
    
    @Column(name = "class_stop_date")
    private String class_stop_date;
    
    @Column(name = "is_class_stop")
    private String is_class_stop;
    
    @Column(name = "is_agreement_sent_to_parent")
    private String is_agreement_sent_to_parent;
    
    @Column(name = "is_agreemenet_sent_to_tutor")
    private String is_agreemenet_sent_to_tutor;
    
    @Column(name = "package_in_hrs")
    private String package_in_hrs;
    
    @Column(name = "hourly_rate")
    private String hourly_rate;
    
    @Column(name = "registration_fee_amount")
    private String registration_fee_amount;
    
    @Column(name = "is_registration_paid")
    private String is_registration_paid;
    
    @Column(name = "total_tuition_fee")
    private String total_tuition_fee;
    
    @Column(name = "csquare_income")
    private String csquare_income;
    
   

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

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String getExisting_client() {
		return existing_client;
	}

	public void setExisting_client(String existing_client) {
		this.existing_client = existing_client;
	}

	public String getSource_of_lead() {
		return source_of_lead;
	}

	public void setSource_of_lead(String source_of_lead) {
		this.source_of_lead = source_of_lead;
	}

	public String getIs_hold() {
		return is_hold;
	}

	public void setIs_hold(String is_hold) {
		this.is_hold = is_hold;
	}

	public String getStudent_record_owner() {
		return student_record_owner;
	}

	public void setStudent_record_owner(String student_record_owner) {
		this.student_record_owner = student_record_owner;
	}

	public String getIs_parent_doc_submitted() {
		return is_parent_doc_submitted;
	}

	public void setIs_parent_doc_submitted(String is_parent_doc_submitted) {
		this.is_parent_doc_submitted = is_parent_doc_submitted;
	}

	public String getIs_intrested() {
		return is_intrested;
	}

	public void setIs_intrested(String is_intrested) {
		this.is_intrested = is_intrested;
	}

	public String getIs_not_interested() {
		return is_not_interested;
	}

	public void setIs_not_interested(String is_not_interested) {
		this.is_not_interested = is_not_interested;
	}

	public String getIs_demo_required() {
		return is_demo_required;
	}

	public void setIs_demo_required(String is_demo_required) {
		this.is_demo_required = is_demo_required;
	}

	public String getDemo_date() {
		return demo_date;
	}

	public void setDemo_date(String demo_date) {
		this.demo_date = demo_date;
	}

	public String getIs_converted() {
		return is_converted;
	}

	public void setIs_converted(String is_converted) {
		this.is_converted = is_converted;
	}

	public String getEnrollment_date() {
		return enrollment_date;
	}

	public void setEnrollment_date(String enrollment_date) {
		this.enrollment_date = enrollment_date;
	}

	public String getIs_followup_required() {
		return is_followup_required;
	}

	public void setIs_followup_required(String is_followup_required) {
		this.is_followup_required = is_followup_required;
	}

	public String getNext_followup_date() {
		return next_followup_date;
	}

	public void setNext_followup_date(String next_followup_date) {
		this.next_followup_date = next_followup_date;
	}

	public String getPreffered_call_time() {
		return preffered_call_time;
	}

	public void setPreffered_call_time(String preffered_call_time) {
		this.preffered_call_time = preffered_call_time;
	}

	public String getIs_conversion_pending() {
		return is_conversion_pending;
	}

	public void setIs_conversion_pending(String is_conversion_pending) {
		this.is_conversion_pending = is_conversion_pending;
	}

	public String getIs_home_tuition_stop() {
		return is_home_tuition_stop;
	}

	public void setIs_home_tuition_stop(String is_home_tuition_stop) {
		this.is_home_tuition_stop = is_home_tuition_stop;
	}

	public String getClass_stop_date() {
		return class_stop_date;
	}

	public void setClass_stop_date(String class_stop_date) {
		this.class_stop_date = class_stop_date;
	}

	public String getIs_class_stop() {
		return is_class_stop;
	}

	public void setIs_class_stop(String is_class_stop) {
		this.is_class_stop = is_class_stop;
	}

	public String getIs_agreement_sent_to_parent() {
		return is_agreement_sent_to_parent;
	}

	public void setIs_agreement_sent_to_parent(String is_agreement_sent_to_parent) {
		this.is_agreement_sent_to_parent = is_agreement_sent_to_parent;
	}

	public String getIs_agreemenet_sent_to_tutor() {
		return is_agreemenet_sent_to_tutor;
	}

	public void setIs_agreemenet_sent_to_tutor(String is_agreemenet_sent_to_tutor) {
		this.is_agreemenet_sent_to_tutor = is_agreemenet_sent_to_tutor;
	}

	public String getPackage_in_hrs() {
		return package_in_hrs;
	}

	public void setPackage_in_hrs(String package_in_hrs) {
		this.package_in_hrs = package_in_hrs;
	}

	public String getHourly_rate() {
		return hourly_rate;
	}

	public void setHourly_rate(String hourly_rate) {
		this.hourly_rate = hourly_rate;
	}

	public String getRegistration_fee_amount() {
		return registration_fee_amount;
	}

	public void setRegistration_fee_amount(String registration_fee_amount) {
		this.registration_fee_amount = registration_fee_amount;
	}

	public String getIs_registration_paid() {
		return is_registration_paid;
	}

	public void setIs_registration_paid(String is_registration_paid) {
		this.is_registration_paid = is_registration_paid;
	}

	public String getTotal_tuition_fee() {
		return total_tuition_fee;
	}

	public void setTotal_tuition_fee(String total_tuition_fee) {
		this.total_tuition_fee = total_tuition_fee;
	}

	public String getCsquare_income() {
		return csquare_income;
	}

	public void setCsquare_income(String csquare_income) {
		this.csquare_income = csquare_income;
	}

	
	
}
