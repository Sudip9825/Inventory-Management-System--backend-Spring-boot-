package com.sudip.application.Inventory.Management.System.controller;

import com.sudip.application.Inventory.Management.System.core.dto.ApiResponse;
import com.sudip.application.Inventory.Management.System.core.dto.PaginationDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.DeleteSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.RegisterSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.UpdateSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @PostMapping("/save")
    public ResponseEntity<ApiResponse<?>> saveSupplier(@RequestBody @Valid RegisterSupplierRequestDto registerSupplierRequestDto){
        ApiResponse<?> apiResponse= supplierService.saveSupplier(registerSupplierRequestDto);
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping("/update{id}")
    public ResponseEntity<ApiResponse<?>> updateSupplier(@RequestBody @Valid UpdateSupplierRequestDto updateSupplierRequestDto){
        return supplierService.updateSupplier(updateSupplierRequestDto);
    }
    @PostMapping("/get")
    public ResponseEntity<ApiResponse<?>> getAllSuppliers(@RequestBody @Valid PaginationDto paginationDto) {
       ApiResponse<?> apiResponse=  supplierService.listSupplier(paginationDto);
       return ResponseEntity.ok(apiResponse);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCustomer(@PathVariable DeleteSupplierRequestDto id ) {
        return supplierService.deleteSupplier(id);
    }
}
