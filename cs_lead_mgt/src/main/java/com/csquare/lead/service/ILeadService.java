package com.csquare.lead.service;

import java.util.ArrayList;
import java.util.List;

import com.csquare.lead.model.Lead;

public interface ILeadService {

    public Lead addLead(Lead lead);

    public Lead updateLead(Lead lead);
    
    public void deleteLead(String leadId);
    
    public Lead getLeadById(String id);
    
    public ArrayList<Lead> getAllLeads();

}
