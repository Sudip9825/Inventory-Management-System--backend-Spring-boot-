package com.sudip.application.Inventory.Management.System.core.service;

import org.springframework.scheduling.annotation.Async;

public interface MailService {
    @Async
    void sendMail(SendMailRequest sendMailRequest);


}
