package com.csquare.lead.service;

import java.util.List;

import com.csquare.lead.model.Contact;


public interface IContactService {
//
//    public Lead addLead(Lead lead);
//
//    public Lead updateLead(Lead lead);
//
//    public void deleteLead(String leadId);
//
//    public Lead getLeadById(String id);
//
//    public List<Lead> getAllLeads(int offset, int limit);
//
//    public List<Lead> searchLead(List<SearchCriteria> criterias, int offset, int limit, boolean allMatch);

	public Contact contactUs(Contact contact);

	public void deleteContact(String id);

	public List<Contact> getAllContact(int offset, int limit);

}
