package com.csquare.communication.util;

import com.csquare.framework.message.MailMessage;
import com.csquare.framework.util.FileUtil;
import com.csquare.framework.util.SystemUtil;
import com.csquare.framework.util.SystemUtil.SystemKey;


public class Test {

    public static void main(String[] args) throws Exception {

    	SystemUtil.setEnv(SystemKey.CS_APPCONFIG_PATH, "G:/CsquareProject/backend/backend/cs-app-config");
        // TODO Auto-generated method stub
        MailMessage message = new MailMessage();
        message.setToAddress("rahul.singh0394@gmail.com");
        message.setSubject("Subject");
        String body=FileUtil.STUDENT_ENROLL_MAIL_TEMPLATE.getFileAsString();
        body = body.replace("{%Student_Name%}", "Student Name");
        body = body.replace("{%UserName%)", "Tutor XYZ");
        body = body.replace("{%Password%}", "123$");
        message.setBody(body);
        MailUtil.INSTANCE.sendMail(message);
        // RestServiceClient.INSTANCE.postForObject("http://localhost:8083/cs_communication_mgt/sendEmail", message, String.class);
        System.out.println("done");
    }

}
