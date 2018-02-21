package com.csquare.communication.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.csquare.communication.service.IEmailService;
import com.csquare.communication.util.MailUtil;
import com.csquare.framework.message.MailMessage;
import com.csquare.framework.util.StringUtil;


@Service
public class EmailServiceImpl implements IEmailService {

    private static final Logger LOGGER = LogManager.getLogger(EmailServiceImpl.class);

    @Override
    @Async
    public void sendEmail(MailMessage message) {

        sendMail(message);
    }

    private String sendMail(MailMessage message) {

        try {
            MailUtil.INSTANCE.sendMail(message);
            handleSuccess(message);
            return "SUCCESS";
        } catch (Exception e) {
            // DO NOTHING. TRY AGAIN
        }

        sleep(200);
        try {
            MailUtil.INSTANCE.sendMail(message);
            handleSuccess(message);
            return "SUCCESS";
        } catch (Exception e) {
            // DO NOTHING. TRY AGAIN
        }

        sleep(200);
        try {
            MailUtil.INSTANCE.sendMail(message);
            handleSuccess(message);
            return "SUCCESS";
        } catch (Exception e) {
            handleFailure(message, e);
            return "FAILED";
        }
    }

    /**
     * @param e
     * @return
     */
    private void handleSuccess(MailMessage message1) {

        String successMessage =
            StringUtil.append("Mail Delivered: [[ToAddress: ", message1.getToAddress(), " || Subject: ", message1.getSubject(), "]]");
        LOGGER.info(successMessage);

    }

    /**
     * @param e
     * @return
     */
    private void handleFailure(MailMessage message1, Exception e) {

        String failureMessage =
            StringUtil.append("Mail Un-Delivered: [[ToAddress: ", message1.getToAddress(), " || Subject: ", message1.getSubject(), "]]", e);

        LOGGER.error(failureMessage, e);

    }

    /**
     *
     */
    private void sleep(long millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e2) {
            // DO NOTHING
        }
    }

}
