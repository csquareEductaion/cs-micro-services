package com.csquare.lead.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.lead.dao.LeadStatusRepository;
import com.csquare.lead.model.ref.RefLeadStatus;
import com.csquare.lead.service.ILeadStatusService;


@Service
public class LeadStatusServiceImpl implements ILeadStatusService {

    @Autowired
    LeadStatusRepository ileadStatusRepository;

    @Override
    public RefLeadStatus addLeadStatus(RefLeadStatus leadStatus) {

        // TODO Auto-generated method stub
        leadStatus = ileadStatusRepository.save(leadStatus);
        return leadStatus;
    }

    @Override
    public RefLeadStatus updateLeadStatus(RefLeadStatus leadStatus) {

        leadStatus = ileadStatusRepository.save(leadStatus);
        return leadStatus;
    }

    @Override
    public void deleteLeadStatus(String leadId) {

        ileadStatusRepository.delete(leadId);
    }

    @Override
    public RefLeadStatus getLeadStatusById(String id) {

        return ileadStatusRepository.findOne(id);
    }

    @Override
    public List<RefLeadStatus> getAllLeadStatus() {

        return ileadStatusRepository.findAll();
    }

    @Override
    public List<RefLeadStatus> getAllLeadStatus(int offset, int limit) {

        return ileadStatusRepository.findAll(offset, limit);
    }

}
