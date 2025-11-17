package com.sudip.application.Inventory.Management.System.coredto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMailRequest {

    @NotBlank(message="Receipient mail is required")
    private String recipientEmail;

    @NotBlank(message = "Subject is requird")
    private String subject;

    @NotBlank(message = "message is requird")
    private String message;
}
