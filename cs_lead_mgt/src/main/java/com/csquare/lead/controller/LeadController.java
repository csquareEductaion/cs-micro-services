package com.csquare.lead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.lead.model.Lead;
import com.csquare.lead.service.ILeadService;



@RestController
public class LeadController extends RestExceptionHandler {

    @Autowired
    ILeadService iLeadService;

    @RequestMapping(value = "/addLead", method = RequestMethod.POST, headers = "Accept=application/json")
    public Lead addLead(@RequestBody Lead lead) {

        lead = iLeadService.addLead(lead);
        return lead;
    }

    @RequestMapping(value = "/updateLead", method = RequestMethod.POST, headers = "Accept=application/json")
    public Lead updateLead(@RequestBody Lead lead) {

        lead = iLeadService.updateLead(lead);
        return lead;
    }
    
    @RequestMapping(value = "/deleteLead", method = RequestMethod.POST, headers = "Accept=application/json")
    public void updateLead(@RequestBody String leadId) {

        iLeadService.deleteLead(leadId);
    }
    
    @RequestMapping(value = "/getLeadById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Lead getLeadById(@PathVariable String id) {

        Lead lead = iLeadService.getLeadById(id);
        return lead;
    }

}
