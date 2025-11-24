package com.sudip.application.Inventory.Management.System.core.service;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMailRequest {

    @NotBlank(message="Receipient mail is required")
    private String recipientEmail;

    @NotBlank(message = "Subject is required")
    private String subject;

    @NotBlank(message = "message is required")
    private String message;
}
