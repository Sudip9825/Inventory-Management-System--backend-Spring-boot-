package com.sudip.application.Inventory.Management.System.dto.productdto;

import com.sudip.application.Inventory.Management.System.dto.supplierdto.SupplierModel;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewProductRequest {
@NotNull(message="cant be null")
    private Integer productId;
    private SupplierModel supplier;
    private String SupplierName;
    @NotNull(message="cant be null")
    private Integer quantity;
//private String uniqueId;

}
