package com.csquare.lead.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.framework.validation.CSquareInputDataValidator;
import com.csquare.lead.model.Lead;
import com.csquare.lead.model.search.SearchCriteria;
import com.csquare.lead.service.ILeadService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LeadController extends RestExceptionHandler {

    @Autowired
    ILeadService iLeadService;

    @RequestMapping(value = "/addLead", method = RequestMethod.POST, headers = "Accept=application/json")
    public Lead addLead(@RequestBody Lead lead) throws ValidationException {

        if (lead != null && CSquareInputDataValidator.validatePhoneNumber(String.valueOf(lead.getPhone()))
            && CSquareInputDataValidator.isValidEmailAddress(lead.getEmail())) {
            lead = iLeadService.addLead(lead);

        }
        return lead;
    }

    @RequestMapping(value = "/updateLead", method = RequestMethod.POST, headers = "Accept=application/json")
    public Lead updateLead(@RequestBody Lead lead) throws ValidationException {

        if (lead != null && CSquareInputDataValidator.validatePhoneNumber(String.valueOf(lead.getPhone()))
            && CSquareInputDataValidator.isValidEmailAddress(lead.getEmail())) {
            lead = iLeadService.updateLead(lead);

        }
        return lead;
    }

    @RequestMapping(value = "/deleteLead/{leadId}", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteLead(@PathVariable String leadId) {

        if (leadId != null)
            iLeadService.deleteLead(leadId);
    }

    @RequestMapping(value = "/getLeadById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Lead getLeadById(@PathVariable String id) {

        Lead lead = null;
        if (id != null)
            lead = iLeadService.getLeadById(id);
        return lead;
    }

    @RequestMapping(value = "/getAllLeads/{offset}/{limit}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Lead> getAllLeads(@PathVariable Integer offset, @PathVariable Integer limit) {

        List<Lead> leads = iLeadService.getAllLeads(offset, limit);
        return leads;
    }

    @RequestMapping(value = "/searchLead/{offset}/{limit}", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<Lead> searchLead(@RequestBody List<SearchCriteria> searchCriteriaList, @PathVariable Integer offset, @PathVariable Integer limit) {

        List<Lead> leadList = iLeadService.searchLead(searchCriteriaList, offset, limit);
        return leadList;
    }
}
