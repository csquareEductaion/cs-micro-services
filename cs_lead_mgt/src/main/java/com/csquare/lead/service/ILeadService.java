package com.csquare.lead.service;

import java.util.List;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.lead.model.Lead;


public interface ILeadService {

    public Lead addLead(Lead lead);

    public Lead updateLead(Lead lead);

    public void deleteLead(String leadId);

    public Lead getLeadById(String id);

    public List<Lead> getAllLeads(int offset, int limit);

    public List<Lead> searchLead(List<SearchCriteria> searchCriteriaList, int offset, int limit);

}
