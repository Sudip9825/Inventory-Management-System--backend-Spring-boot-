package com.sudip.application.Inventory.Management.System.dto.productdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.SupplierModel;
import com.sudip.application.Inventory.Management.System.entity.Supplier;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ListProductResponseDto implements Serializable {


    private String productName;


    private String category;

    private Double price;


    private Integer quantity;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:s a")
    private LocalDateTime createdAt;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:s a")
    private LocalDateTime updatedAt;
    private Integer supplierId;
    private String supplierName;

    private String uniqueId;

    private SupplierModel supplier;

}
