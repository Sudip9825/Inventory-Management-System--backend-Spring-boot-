package com.sudip.application.Inventory.Management.System.dto.productdto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewProductRequest {
@NotNull(message="cant be null")
    private Integer productId;
//private String uniqueId;

}
