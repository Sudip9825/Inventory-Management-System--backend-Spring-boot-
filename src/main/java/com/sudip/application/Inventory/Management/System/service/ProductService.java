package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.core.dto.ApiResponse;
import com.sudip.application.Inventory.Management.System.core.dto.PaginationDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.DeleteProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.RegisterProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.UpdateProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.ViewProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
public ResponseEntity<ApiResponse<?>> addProduct(RegisterProductRequestDto registerProductRequestDto, MultipartFile productPicture);
public ResponseEntity<ApiResponse<?>> updateProduct(UpdateProductRequestDto updateProductRequestDto);
public ResponseEntity<ApiResponse<?>> deleteProduct(DeleteProductRequestDto deleteProductRequestDto);
public ApiResponse<?>getAllProduct(PaginationDto paginationDto);
public ResponseEntity<ApiResponse<?>> getProductByName(String productName);
public ResponseEntity<ApiResponse<?>> viewProduct(ViewProductRequest viewProductRequestDto);

}
