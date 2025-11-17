package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.coredto.SendMailRequest;
import com.sudip.application.Inventory.Management.System.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service

public class EmailServiceTemplateImplementation implements EmailTemplateService {
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private MailService mailService;

    @Override
    public void sendWelcomeMail(Supplier supplier) {
        Context context = new Context();
        context.setVariable("fullName", supplier.getSupplierName());
        context.setVariable("email", supplier.getEmail());
        String message = templateEngine.process("email/welcome-email", context);

        SendMailRequest sendMailRequest = new SendMailRequest();
        sendMailRequest.setRecipientEmail(supplier.getEmail());
        sendMailRequest.setSubject("supply received");
        sendMailRequest.setMessage(message);
        mailService.sendMail(sendMailRequest);

    }
}
