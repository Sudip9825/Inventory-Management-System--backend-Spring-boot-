package com.sudip.application.Inventory.Management.System.dto.supplierdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSupplierRequestDto {
@NotNull(message ="enter id")
    private Integer id;
    @NotBlank(message = "Supplier  name is required")
private String SupplierName;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
private String email;
    @NotBlank(message = "Supplier  number is required")
    private String phoneNumber;
}
