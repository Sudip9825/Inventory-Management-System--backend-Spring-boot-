package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.coredto.ApiResponse;
import com.sudip.application.Inventory.Management.System.coredto.PaginationDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.DeleteProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.RegisterProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.UpdateProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.ViewProductRequest;
import org.springframework.http.ResponseEntity;

public interface ProductService {
public ResponseEntity<ApiResponse<?>> addProduct(RegisterProductRequestDto registerProductRequestDto);
public ResponseEntity<ApiResponse<?>> updateProduct(UpdateProductRequestDto updateProductRequestDto);
public ResponseEntity<ApiResponse<?>> deleteProduct(DeleteProductRequestDto deleteProductRequestDto);
public ResponseEntity<ApiResponse<?>> getAllProduct(PaginationDto paginationDto);
public ResponseEntity<ApiResponse<?>> getProductByName(String productName);
public ResponseEntity<ApiResponse<?>> viewProduct(ViewProductRequest viewProductRequestDto);

}
