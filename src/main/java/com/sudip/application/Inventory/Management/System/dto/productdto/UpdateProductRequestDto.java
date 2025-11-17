package com.sudip.application.Inventory.Management.System.dto.productdto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequestDto {
    @NotBlank(message = "unique id is nedeed")
    private String uniqueId;

    @NotBlank(message = "product name")
    private String productName;

    @NotBlank(message = "category name needed")
    private String category;

    private String supplier;
}
