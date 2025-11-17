package com.sudip.application.Inventory.Management.System.controller;

import com.sudip.application.Inventory.Management.System.coredto.ApiResponse;
import com.sudip.application.Inventory.Management.System.coredto.PaginationDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.DeleteProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.RegisterProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.UpdateProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.ViewProductRequest;
import com.sudip.application.Inventory.Management.System.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<?>> saveProduct(@RequestBody @Valid RegisterProductRequestDto registerProductRequestDto) {
        return productService.addProduct(registerProductRequestDto);
    }

    @PostMapping("/list")
    public ResponseEntity<ApiResponse<?>> listAllProducts(@RequestBody @RequestParam PaginationDto paginationDto) {
        return productService.getAllProduct(paginationDto);
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
