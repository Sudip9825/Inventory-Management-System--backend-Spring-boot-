package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.coredto.ApiResponse;
import com.sudip.application.Inventory.Management.System.coredto.PaginationDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.DeleteSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.RegisterSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.UpdateSupplierRequestDto;
import org.springframework.http.ResponseEntity;

public interface SupplierService {
    ResponseEntity<ApiResponse<?>> saveSupplier(RegisterSupplierRequestDto registerSupplierRequestDto);

    ResponseEntity<ApiResponse<?>> listSupplier(PaginationDto paginationDto);

    //ResponseEntity<ApiResponse<?>> viewSupplier(ViewSupplierRequestDto viewSupplierRequestDto);

    ResponseEntity<ApiResponse<?>> deleteSupplier(DeleteSupplierRequestDto deleteSupplierRequestDto);

    ResponseEntity<ApiResponse<?>> updateSupplier(UpdateSupplierRequestDto updateSupplierRequestDto);
}
