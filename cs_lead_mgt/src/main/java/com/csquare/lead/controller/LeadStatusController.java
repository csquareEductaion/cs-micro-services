package com.csquare.lead.controller;

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
import com.csquare.lead.model.ref.RefLeadStatus;
import com.csquare.lead.service.ILeadStatusService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LeadStatusController extends RestExceptionHandler {

    @Autowired
    ILeadStatusService iLeadStatusService;

    @RequestMapping(value = "/addLeadStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefLeadStatus addLeadStatus(@RequestBody RefLeadStatus leadStatus) throws ValidationException {

        return iLeadStatusService.addLeadStatus(leadStatus);

    }

    @RequestMapping(value = "/updateLeadStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefLeadStatus updateLeadStatus(@RequestBody RefLeadStatus leadStatus) throws ValidationException {

        return iLeadStatusService.updateLeadStatus(leadStatus);
    }

    @RequestMapping(value = "/deleteLeadStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteLeadStatus(@RequestBody String leadStatusId) {

        if (leadStatusId != null)
            iLeadStatusService.deleteLeadStatus(leadStatusId);
    }

    @RequestMapping(value = "/getLeadStatusById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public RefLeadStatus getLeadStatusById(@PathVariable String id) {

        RefLeadStatus leadStatus = null;
        if (id != null)
            leadStatus = iLeadStatusService.getLeadStatusById(id);
        return leadStatus;
    }

    @RequestMapping(value = "/getAllLeadStatus", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<RefLeadStatus> getAllLeadStatus() {

        List<RefLeadStatus> leadStatus = iLeadStatusService.getAllLeadStatus();
        return leadStatus;
    }

    @RequestMapping(value = "/getAllLeadStatus/{offset}/{limit}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<RefLeadStatus> getAllLeadStatus(@PathVariable Integer offset, @PathVariable Integer limit) {

        List<RefLeadStatus> leadStatus = iLeadStatusService.getAllLeadStatus(offset, limit);
        return leadStatus;
    }
}
