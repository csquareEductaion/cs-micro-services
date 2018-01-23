package com.csquare.lead.service;

import java.util.List;

import com.csquare.lead.model.ref.RefLeadStatus;


public interface ILeadStatusService {

    public RefLeadStatus addLeadStatus(RefLeadStatus leadStatus);

    public RefLeadStatus updateLeadStatus(RefLeadStatus leadStatus);

    public void deleteLeadStatus(String leadStatusId);

    public RefLeadStatus getLeadStatusById(String leadStatusId);

    public List<RefLeadStatus> getAllLeadStatus();

    public List<RefLeadStatus> getAllLeadStatus(int offset, int limit);

}
