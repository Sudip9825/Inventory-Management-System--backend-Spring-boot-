package com.sudip.application.Inventory.Management.System.dto.productdto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteProductRequestDto {
    @NotBlank(message =" Product name required")
    private Integer ProductId;
//    private String productName;
//    private String uniqueId;

}
