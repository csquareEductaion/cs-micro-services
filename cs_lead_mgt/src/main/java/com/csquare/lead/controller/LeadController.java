package com.csquare.lead.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.lead.model.Lead;
import com.csquare.lead.service.ILeadService;
import com.csquare.lead.validation.CSquareInputDataValidator;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LeadController extends RestExceptionHandler {

    @Autowired
    ILeadService iLeadService;

    @RequestMapping(value = "/addLead", method = RequestMethod.POST, headers = "Accept=application/json")
    public Lead addLead(@RequestBody Lead lead) {
    	
    	if(lead !=null 
    			&& CSquareInputDataValidator.validatePhoneNumber(String.valueOf(lead.getPhone()))
    			&& CSquareInputDataValidator.isValidEmailAddress(lead.getEmail())){
    		lead = iLeadService.addLead(lead);
    		Lead lead1= iLeadService.getLeadById(lead.getpK());
    		return lead1;
            
    	}
    	//lead = iLeadService.addLead(lead);
    	return lead;
    }

    @RequestMapping(value = "/updateLead", method = RequestMethod.POST, headers = "Accept=application/json")
    public Lead updateLead(@RequestBody Lead lead) {
    	
    	if(lead !=null 
    			&& CSquareInputDataValidator.validatePhoneNumber(String.valueOf(lead.getPhone()))
    			&& CSquareInputDataValidator.isValidEmailAddress(lead.getEmail())){
    		lead = iLeadService.updateLead(lead);
            
    	}
        return lead;
    }
    
    @RequestMapping(value = "/deleteLead", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteLead(@RequestBody String leadId) {
    	
    	if(leadId !=null)
    		iLeadService.deleteLead(leadId);
    }
    
    @RequestMapping(value = "/getLeadById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Lead getLeadById(@PathVariable String id) {
    	
    	Lead lead = null;
    	if(id !=null)
    		lead = iLeadService.getLeadById(id);
        return lead;
    }
    
    @RequestMapping(value = "/getAllLeads", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<Lead> getAllLeads() {
    	    	
    	ArrayList<Lead> leads = iLeadService.getAllLeads();
        return leads;
    }
    
  /*  @RequestMapping(value = "/getAllLeads/{startpoint}/pagesize/{pagesize}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<Lead> getAllLeads(@PathVariable(value = "startpoint") String startpoint, @PathVariable(value = "pagesize") String pagesize) {
    	
    	//Pageable pageable = new PageRequest(Integer.valueOf(startpoint), Integer.valueOf(pagesize));
    	Pageable pageable = new PageRequest(0, 2);
    	
    	System.out.println("Integer.valueOf(startpoint)--" + Integer.valueOf(startpoint));
    	System.out.println("Integer.valueOf(pagesize)--" + Integer.valueOf(pagesize));
    	ArrayList<Lead> leads = iLeadService.getAllLeads(pageable);
        return leads;
    }*/

}
