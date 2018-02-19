package com.csquare.lead.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.lead.dao.LeadRepository;
import com.csquare.lead.model.Lead;
import com.csquare.lead.service.ILeadService;


@Service
public class LeadServiceImpl implements ILeadService {

    @Autowired
    private LeadRepository ileadRepository;

    @Override
    public Lead addLead(Lead lead) {

        lead = ileadRepository.create(lead);
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
    public List<Lead> getAllLeads(int offset, int limit) {

        return ileadRepository.findAll(offset, limit, "leadGradeList", "leadLocationList", "leadSubjectList", "leadSyllabusList");
    }

    @Override
    public List<Lead> searchLead(List<SearchCriteria> criterias, int offset, int limit, boolean allMatch) {

        List<Lead> leadList =
            ileadRepository.search(criterias, offset, limit, allMatch, "leadGradeList", "leadLocationList", "leadSubjectList", "leadSyllabusList");
        return leadList;
    }

}
