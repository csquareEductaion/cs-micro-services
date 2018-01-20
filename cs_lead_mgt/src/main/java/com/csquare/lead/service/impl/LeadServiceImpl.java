package com.csquare.lead.service.impl;

import java.util.List;

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

        ileadRepository.delete(leadId);
        ;
    }

    @Override
    public Lead getLeadById(String id) {

        return ileadRepository.findOne(id);
    }

    @Override
    public List<Lead> getAllLeads() {

        return ileadRepository.findAll();
    }

    @Override
    public List<Lead> getAllLeads(int offset, int limit) {

        return ileadRepository.findAll(offset, limit);
    }

}
