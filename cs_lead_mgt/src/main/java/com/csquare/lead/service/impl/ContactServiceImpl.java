package com.csquare.lead.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.lead.dao.ContactRepository;
import com.csquare.lead.model.Contact;
import com.csquare.lead.service.IContactService;;


@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private ContactRepository iContactRepository;

	@Override
	public Contact contactUs(Contact contact) {
		// TODO Auto-generated method stub
		return iContactRepository.create(contact);
	}

	@Override
	public void deleteContact(String id) {
		// TODO Auto-generated method stub
		iContactRepository.delete(id);
	}

	@Override
	public List<Contact> getAllContact(int offset, int limit) {
		// TODO Auto-generated method stub
		 return iContactRepository.findAll(offset, limit);
	}

}
