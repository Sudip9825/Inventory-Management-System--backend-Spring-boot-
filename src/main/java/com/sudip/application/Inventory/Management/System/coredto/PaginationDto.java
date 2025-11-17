package com.sudip.application.Inventory.Management.System.coredto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDto {
    @NotNull(message = "should not be  null") @Min(value = 0,message = "must start form zero")
    private int page;

    @NotNull(message = "should not be  null") @Min(value = 1, message = "Size must be at least 1")
    private int size;


    private String keyword;


}
