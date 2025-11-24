package com.sudip.application.Inventory.Management.System.core.service;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImplentation implements MailService {
    private static final Logger log = LoggerFactory.getLogger(MailServiceImplentation.class);

    @Value("sudipdahal779@gmail.com")
    private String sender;

    @Autowired
    private JavaMailSender mailSender;
    @Async
    @Override
    public void sendMail(SendMailRequest sendMailRequest) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(sendMailRequest.getRecipientEmail());
            mimeMessageHelper.setSubject(sendMailRequest.getSubject());
            mimeMessageHelper.setText(sendMailRequest.getMessage(), true);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error(e.getMessage());

            throw new RuntimeException(e);
        }
    }

}



