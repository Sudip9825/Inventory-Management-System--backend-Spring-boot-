package com.sudip.application.Inventory.Management.System.dto.productdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterProductRequestDto {

    @NotBlank(message=" this field cannot be empty")
    private String productName;

    private String category;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer quantity;

    @NotNull(message = "Supplier cannot be null")
    private Integer supplierId;

}
