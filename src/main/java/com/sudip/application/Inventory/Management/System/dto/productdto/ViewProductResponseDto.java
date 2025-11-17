package com.sudip.application.Inventory.Management.System.dto.productdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sudip.application.Inventory.Management.System.entity.Supplier;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ViewProductResponseDto {
    private String productName;


    private String category;

    private Double price;


    private Integer quantity;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:s a")
    private LocalDateTime createdAt;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:s a")
    private LocalDateTime updatedAt;



    private String uniqueId;

    private Supplier supplier;
}
