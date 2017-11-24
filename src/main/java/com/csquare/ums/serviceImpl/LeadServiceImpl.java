package com.csquare.ums.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ums.dao.LeadRepository;
import com.csquare.ums.entity.Lead;
import com.csquare.ums.service.ILeadService;

@Service
public class LeadServiceImpl implements ILeadService {
	
	
	
	@Autowired
	LeadRepository ileadRepository;

	@Override
	public Lead addUpdateLead(Lead lead) {
		// TODO Auto-generated method stub
		ileadRepository.save(lead);
		return lead;
	}

	@Override
	public Lead getLeadById(Long id) {
		// TODO Auto-generated method stub
		return ileadRepository.findOne(id);
	}

}
