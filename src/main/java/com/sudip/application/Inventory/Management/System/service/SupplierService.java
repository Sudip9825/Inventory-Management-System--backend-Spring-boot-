package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.core.dto.ApiResponse;
import com.sudip.application.Inventory.Management.System.core.dto.PaginationDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.DeleteSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.RegisterSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.UpdateSupplierRequestDto;
import org.springframework.http.ResponseEntity;

public interface SupplierService {
    ApiResponse<?>saveSupplier(RegisterSupplierRequestDto registerSupplierRequestDto);

    ApiResponse<?>listSupplier(PaginationDto paginationDto);

    //ResponseEntity<ApiResponse<?>> viewSupplier(ViewSupplierRequestDto viewSupplierRequestDto);

    ResponseEntity<ApiResponse<?>> deleteSupplier(DeleteSupplierRequestDto deleteSupplierRequestDto);

    ResponseEntity<ApiResponse<?>> updateSupplier(UpdateSupplierRequestDto updateSupplierRequestDto);
}
