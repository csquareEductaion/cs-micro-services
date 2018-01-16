package com.csquare.lead.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.lead.dao.LeadRepository;
import com.csquare.lead.model.Lead;
import com.csquare.lead.service.ILeadService;




@Service
public class LeadServiceImpl implements ILeadService {

    @Autowired
    LeadRepository ileadRepository;

    @Override
    public Lead addLead(Lead lead) {

    	String pk=UUID.randomUUID().toString();
    	lead.setpK(pk);
        // TODO Auto-generated method stub
        ileadRepository.save(lead); 
        return lead;
    }
    
    @Override
    public Lead updateLead(Lead lead) {
	
        ileadRepository.save(lead);
        return lead;
    }
    
    @Override
    public void deleteLead(String leadId) {
	
        ileadRepository.delete(leadId);;
    }

    @Override
    public Lead getLeadById(String id) {
        return ileadRepository.findOne(id);
    }

	@Override
	public ArrayList<Lead> getAllLeads() {
		
		return (ArrayList<Lead>) ileadRepository.findAll();
	}
	
/*	@Override
	public ArrayList<Lead> getAllLeads(Pageable pageable) {
		
		return (ArrayList<Lead>) ileadRepository.findAll(pageable);
	}*/

}
