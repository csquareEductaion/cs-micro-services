package com.csquare.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.ums.model.Lead;
import com.csquare.ums.service.ILeadService;


@RestController
public class LeadController extends RestExceptionHandler {

    @Autowired
    ILeadService iLeadService;

    @RequestMapping(value = "/addLead", method = RequestMethod.POST, headers = "Accept=application/json")
    public Lead addLead(@RequestBody Lead lead) {

        lead = iLeadService.addUpdateLead(lead);
        return lead;
    }

    @RequestMapping(value = "/getLeadById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Lead getLeadById(@PathVariable Long id) {

        Lead lead = iLeadService.getLeadById(id);
        return lead;
    }

}
