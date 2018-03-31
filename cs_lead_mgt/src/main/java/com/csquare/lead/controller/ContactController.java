package com.csquare.lead.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.lead.model.Contact;
import com.csquare.lead.service.IContactService;;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactController extends RestExceptionHandler {

    @Autowired
    IContactService iContactService;
    
    @RequestMapping(value = "/contactUs", method = RequestMethod.POST, headers = "Accept=application/json")
    public Contact contactUs(@RequestBody Contact contact) {

         contact = iContactService.contactUs(contact);
        return contact;
    }
    
    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteContact(@PathVariable String id) {

        if (id != null)
        	iContactService.deleteContact(id);
    }

    @RequestMapping(value = "/getAllContact", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Contact> getAllContact() {

        List<Contact> contacts = iContactService.getAllContact(-1, -1);
        return contacts;
    }
}
