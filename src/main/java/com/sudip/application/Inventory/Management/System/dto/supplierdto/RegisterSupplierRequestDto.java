package com.sudip.application.Inventory.Management.System.dto.supplierdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterSupplierRequestDto {
    @NotBlank( message="supplier name needed")
    private String supplierName;

    @NotBlank(message = "Email is required")
    @Email(message="invalid email format")
    private String email;

    @NotBlank(message = "phoneNumber is required")
    private String phoneNumber;

    @NotBlank(message = "adderess is required")
    private String address;

    @NotBlank(message = "adderess is required")
    private String password;

}
