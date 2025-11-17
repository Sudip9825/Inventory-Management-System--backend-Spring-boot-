package com.sudip.application.Inventory.Management.System.dto.supplierdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter

@Setter
public class ListSupplierResponseDto {
    private Integer id;


    private String SupplierName;


    private String email;


    private String phoneNumber;


    private String address;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:s a")
    private LocalDateTime createdAt = LocalDateTime.now();
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:s a")
    private LocalDateTime updatedAt = LocalDateTime.now();


    //private boolean isDeleted = false;


   // private String uniqueId;



}
