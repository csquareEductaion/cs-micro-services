package com.csquare.lead.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.lead.dao.LeadRepository;
import com.csquare.lead.model.Lead;
import com.csquare.lead.model.LeadGrade;
import com.csquare.lead.model.LeadLocation;
import com.csquare.lead.model.LeadSubject;
import com.csquare.lead.model.LeadSyllabus;
import com.csquare.lead.model.ref.RefLeadStatus;
import com.csquare.lead.service.ILeadService;




@Service
public class LeadServiceImpl implements ILeadService {

    @Autowired
    LeadRepository ileadRepository;

    @Override
    public Lead addLead(Lead lead) {

//    	String pk=UUID.randomUUID().toString();
//    	lead.setpK(pk);
//    	
//    	for(LeadGrade lg:lead.getLeadGradeList()){
//    		lg.setPk(UUID.randomUUID().toString());
//    		lg.setLeadId(pk);
//    	}
//    	
//    	for(LeadLocation lg:lead.getLeadLocationList()){
//    		lg.setPk(UUID.randomUUID().toString());
//    		lg.setLeadId(pk);
//    	}
//    	
//    	for(LeadSubject lg:lead.getLeadSubjectList()){
//    		lg.setPk(UUID.randomUUID().toString());
//    		lg.setLeadId(pk);
//    	}
//    	
//    	for(LeadSyllabus lg:lead.getLeadSyllabusList()){
//    		lg.setPk(UUID.randomUUID().toString());
//    		lg.setLeadId(pk);
//    	}
    	
    	lead.setIsstudent(Boolean.valueOf(lead.getIsstudent()));
    	lead.setIstutor(Boolean.valueOf(lead.getIstutor()));
    	
        // TODO Auto-generated method stub
        ileadRepository.save(lead); 
        return lead;
    }
    
    @Override
    public Lead updateLead(Lead lead) {
    	
    	String pk = lead.getpK();
    	for(LeadGrade lg:lead.getLeadGradeList()){
    		if(lg.getPk() ==null){
    			lg.setPk(UUID.randomUUID().toString());
        		lg.setLeadId(pk);
    		}
    		
    	}
    	
    	for(LeadLocation lg:lead.getLeadLocationList()){
    		if(lg.getPk() ==null){
    			lg.setPk(UUID.randomUUID().toString());
        		lg.setLeadId(pk);
    		}
    	}
    	
    	for(LeadSubject lg:lead.getLeadSubjectList()){
    		lg.setPk(UUID.randomUUID().toString());
    		lg.setLeadId(pk);
    	}
    	
    	for(LeadSyllabus lg:lead.getLeadSyllabusList()){
    		if(lg.getPk() ==null){
    			lg.setPk(UUID.randomUUID().toString());
        		lg.setLeadId(pk);
    		}
    	}
    	
    	lead.setIsstudent(Boolean.valueOf(lead.getIsstudent()));
    	lead.setIstutor(Boolean.valueOf(lead.getIstutor()));
    	
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
