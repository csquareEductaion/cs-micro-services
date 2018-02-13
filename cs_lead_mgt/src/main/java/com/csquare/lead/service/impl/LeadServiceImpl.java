package com.csquare.lead.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.framework.message.MailMessage;
import com.csquare.framework.util.sdk.RestServiceClient;
import com.csquare.lead.dao.LeadRepository;
import com.csquare.lead.model.Lead;
import com.csquare.lead.model.intregration.User;
import com.csquare.lead.service.ILeadService;
import com.csquare.lead.model.intregration.Student;

@Service
public class LeadServiceImpl implements ILeadService {

    @Autowired
    LeadRepository ileadRepository;

    @Override
    public Lead addLead(Lead lead) {

        // TODO Auto-generated method stub
        lead = ileadRepository.create(lead);
        
        //1. Convert object to JSON string
        User user = new User();
        user.setPhone(Float.valueOf(String.valueOf(lead.getPhone())));
        user.setCity(lead.getCity());
        user.setEmail(lead.getEmail());
        user.setFirstName(lead.getFirstName());
        user.setLastName(lead.getLastName());
        user.setGender(lead.getGender());
        user.setIsActive(true);
        user.setUserName(lead.getEmail());
        user.setAlternate_phone(lead.getAlteratPhone());
        
        if(lead.getIsstudent())
        	user.setUserType("Student");
        if(lead.getIstutor())
        	user.setUserType("Tutor");
        
        RestServiceClient.INSTANCE.postForObject("http://localhost:8084/cs_user_mgt/saveUser", user, String.class);
        
        MailMessage message = new MailMessage();
        message.setToAddress(lead.getEmail());
        message.setSubject("Subject11111111");
        message.setBody("lead is created");
       
        RestServiceClient.INSTANCE.postForObject("http://localhost:8084/cs_communication_mgt/sendEmail", message, String.class);
       
        return lead;
    }

    @Override
    public Lead updateLead(Lead lead) {
   	    lead = ileadRepository.update(lead);
        
   	    //create user
    	User user = new User();
    	user.setPhone(Float.valueOf(String.valueOf(lead.getPhone())));
        user.setCity(lead.getCity());
        user.setEmail(lead.getEmail());
        user.setFirstName(lead.getFirstName());
        user.setLastName(lead.getLastName());
        user.setGender(lead.getGender());
        user.setIsActive(true);
        user.setUserName(lead.getEmail());
        user.setAlternate_phone(lead.getAlteratPhone());
        
        if(lead.getIsstudent())
        	user.setUserType("Student");
        if(lead.getIstutor())
        	user.setUserType("Tutor");
    	
        RestServiceClient.INSTANCE.postForObject("http://localhost:8084/cs_user_mgt/saveUser", user, String.class);
        
        //create student
        Student student = new Student();
        student.setAddress(lead.getAddress());
        student.setCity(lead.getCity());
        student.setEmail(lead.getEmail());
        student.setFirstName(lead.getFirstName());
        student.setGender(lead.getGender());
        student.setGrade(lead.getGender());
        student.setInterested(true);
        student.setLastName(lead.getLastName());
        student.setPhone(Float.valueOf(String.valueOf(lead.getPhone())));
        
        
        
        return lead;
    }

    @Override
    public void deleteLead(String leadId) {

        ileadRepository.delete(leadId);
    }

    @Override
    public Lead getLeadById(String id) {

        return ileadRepository.findOne(id);
    }

    @Override
    public List<Lead> getAllLeads() {

        return ileadRepository.findAll("leadGradeList", "leadLocationList", "leadSubjectList", "leadSyllabusList");
    }

    @Override
    public List<Lead> getAllLeads(int offset, int limit) {

        return ileadRepository.findAll(offset, limit, "leadGradeList", "leadLocationList", "leadSubjectList", "leadSyllabusList");
    }

}
