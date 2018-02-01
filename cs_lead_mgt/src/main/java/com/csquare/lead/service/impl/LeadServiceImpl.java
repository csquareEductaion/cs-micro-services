package com.csquare.lead.service.impl;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.framework.message.MailMessage;
import com.csquare.framework.util.sdk.RestServiceClient;
import com.csquare.lead.dao.LeadRepository;
import com.csquare.lead.model.Lead;
import com.csquare.lead.service.ILeadService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


@Service
public class LeadServiceImpl implements ILeadService {

    @Autowired
    LeadRepository ileadRepository;

    @Override
    public Lead addLead(Lead lead) {

        // TODO Auto-generated method stub
        lead = ileadRepository.create(lead);
        
        //1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(lead);
        System.out.println(json);
        
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
