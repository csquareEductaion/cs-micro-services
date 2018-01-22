package com.csquare.communication.util;

import com.csquare.framework.message.MailMessage;


public class Test {

    public static void main(String[] args) throws Exception {

        // TODO Auto-generated method stub
        MailMessage message = new MailMessage();
        message.setToAddress("vidya.sagar@brillio.com");
        message.setSubject("Subject");
        message.setBody("body");
        MailUtil.INSTANCE.sendMail(message);
        // RestServiceClient.INSTANCE.postForObject("http://localhost:8083/cs_communication_mgt/sendEmail", message, String.class);
        System.out.println("done");
    }

}
