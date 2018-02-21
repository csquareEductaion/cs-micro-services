package com.csquare.communication.service;

import com.csquare.framework.message.MailMessage;


public interface IEmailService {

    public void sendEmail(MailMessage message);

}
