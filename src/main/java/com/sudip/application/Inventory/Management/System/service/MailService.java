package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.coredto.SendMailRequest;
import org.springframework.scheduling.annotation.Async;

public interface MailService {
    @Async
    void sendMail(SendMailRequest sendMailRequest);


}
