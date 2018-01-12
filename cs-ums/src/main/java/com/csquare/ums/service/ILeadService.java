package com.csquare.ums.service;

import com.csquare.ums.model.Lead;


public interface ILeadService {

    public Lead addUpdateLead(Lead lead);

    public Lead getLeadById(Long id);

}
