package com.csquare.communication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.communication.service.IEmailService;
import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.framework.message.MailMessage;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmailController extends RestExceptionHandler {

    @Autowired
    IEmailService iEmailService;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST, headers = "Accept=application/json")
    public String sendEmail(@RequestBody MailMessage message) {

        return iEmailService.sendEmail(message);
    }

}
