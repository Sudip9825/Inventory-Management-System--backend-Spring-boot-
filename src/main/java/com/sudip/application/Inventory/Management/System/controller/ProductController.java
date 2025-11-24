package com.sudip.application.Inventory.Management.System.controller;

import com.sudip.application.Inventory.Management.System.core.dto.ApiResponse;
import com.sudip.application.Inventory.Management.System.core.dto.PaginationDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.DeleteProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.RegisterProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.UpdateProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.ViewProductRequest;
import com.sudip.application.Inventory.Management.System.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value="/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<?>> saveProduct(@RequestPart(value = "data") @Valid RegisterProductRequestDto registerProductRequestDto,
                                                      @RequestPart(value = "productPicture", required = false) MultipartFile productPicture) {
        return productService.addProduct(registerProductRequestDto,productPicture);
    }

    @PostMapping("/list")

    public ResponseEntity<ApiResponse<?>> listAllProducts(@RequestBody   PaginationDto paginationDto) {
        ApiResponse<?> apiResponse= productService.getAllProduct(paginationDto);
        return new  ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
  @PostMapping("/update")
  public ResponseEntity<ApiResponse<?>> updateProduct(@RequestBody UpdateProductRequestDto updateProductRequestDto) {
        return productService.updateProduct(updateProductRequestDto);
  }
    @PostMapping("/delete")
    public ResponseEntity<ApiResponse<?>> deleteProduct(
            @RequestBody @Valid DeleteProductRequestDto dto) {
        return productService.deleteProduct(dto);
    }

    @PostMapping("/{ProductName}")
    public ResponseEntity<ApiResponse<?>> getProductByName(
            @PathVariable String ProductName) {
        return productService.getProductByName(ProductName);

    }
    @PostMapping("/view")
    public ResponseEntity<ApiResponse<?>> viewProduct(@RequestBody @Valid ViewProductRequest viewProductRequestDto) {
        return productService.viewProduct(viewProductRequestDto);
    }

}
