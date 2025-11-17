package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.coredto.ApiResponse;
import com.sudip.application.Inventory.Management.System.coredto.PaginationDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.*;
import com.sudip.application.Inventory.Management.System.entity.Product;
import com.sudip.application.Inventory.Management.System.exception.handler.DuplicateException;
import com.sudip.application.Inventory.Management.System.exception.handler.ResourceNotFoundException;
import com.sudip.application.Inventory.Management.System.mapper.ProductMapper;
import com.sudip.application.Inventory.Management.System.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProductServiceImplementation implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImplementation.class);
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public ResponseEntity<ApiResponse<?>> addProduct(RegisterProductRequestDto registerProductRequestDto) {

        //Mapper ko kam
        Product product = productMapper.createProduct(registerProductRequestDto);
        productRepository.save(product);
        log.info("Product {} has been registered successfully", registerProductRequestDto);

        ApiResponse<Product> apiResponse = new ApiResponse<>(true, "product added successfully", 201, LocalDateTime.now());
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<?>> updateProduct(UpdateProductRequestDto updateProductRequestDto) {
        Optional<Product> productOptional = productRepository.findByUniqueId(updateProductRequestDto.getUniqueId());

        if (!productRepository.existsByUniqueId(updateProductRequestDto.getUniqueId())) {
            log.error("Product with uniqueId {} not found for update", updateProductRequestDto.getUniqueId());
            throw new ResourceNotFoundException("Product not found with uniqueId: ");
        }


        Product existingProduct = productOptional.get();

        //mapper
        Product productToUpdate = productMapper.updateProduct(existingProduct, updateProductRequestDto);
        productRepository.save(productToUpdate);
        log.info("product exists");

        ApiResponse<Product> apiResponse = new ApiResponse<>(true, "product updated successfully", 202, LocalDateTime.now());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);


    }

    @Override
    public ResponseEntity<ApiResponse<?>> deleteProduct(DeleteProductRequestDto deleteProductRequestDto) {

        Optional<Product> product = productRepository.findByUniqueId(deleteProductRequestDto.getProductName());
        if (product.isEmpty()) {
            throw new ResourceNotFoundException("product not found ");
        }
//mapper bata setDeleted
        Product productToDelete = productMapper.deleteProduct(product.get());


        productRepository.save(productToDelete);

        log.info("Product soft-deleted: {}", deleteProductRequestDto.getProductName());

        ApiResponse<?> apiresponse = new ApiResponse<>(
                true,
                "Product deleted successfully",
                200,
                LocalDateTime.now()
        );

        return ResponseEntity.ok(apiresponse);
    }


    @Override
    public ResponseEntity<ApiResponse<?>> getAllProduct(PaginationDto paginationDto) {
        Pageable pageable = PageRequest.of(paginationDto.getPage(), paginationDto.getSize(), Sort.by(Sort.Direction.DESC, "id"));
        Page<Product> products;
        if (paginationDto.getKeyword() != null && !paginationDto.getKeyword().trim().isEmpty()) {
            products = productRepository.searchProduct(paginationDto.getKeyword().trim(), pageable);
        } else {
            products = productRepository.findAll(pageable);
        }
        //map and list
        List<ListProductResponseDto> listProductResponseDtos = productMapper.listAllProduct(products);
        log.info("Product listed successfully");
        ApiResponse<?> response = new ApiResponse<>(true, "product listed successfully", 200, listProductResponseDtos);
        return ResponseEntity.ok(response);
    }

    @Override

    public ResponseEntity<ApiResponse<?>> getProductByName(
            @PathVariable String productName) {

        // Trim whitespace just in case
        if (productName == null || productName.trim().isEmpty()) {
            log.warn("Attempted to search product with empty/blank name");
            throw new ResourceNotFoundException("Product name cannot be empty");
        }

        String trimmedName = productName.trim();

        log.info("Searching for product with name: {}", trimmedName);

        Optional<Product> productOptional = productRepository.findByProductName(trimmedName);


        if (productOptional.isEmpty()) {
            log.error("Product not found with name: {}", trimmedName);
            throw new ResourceNotFoundException("Product not found with name: " + trimmedName);
        }

        Product product = productOptional.get();

        // Map Entity → DTO
        ViewProductResponseDto productDto = productMapper.entityToviewDetails(product);

        log.info("Product retrieved successfully with name: {}", trimmedName);

        ApiResponse<ViewProductResponseDto> response =
                new ApiResponse<>(true, "Product retrieved successfully", 200, productDto);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<?>> viewProduct(ViewProductRequest viewProductRequestDto) {

        Optional<Product> product = productRepository.findById(viewProductRequestDto.getProductId());

        if (product.isEmpty()) {
            log.error("Product not found with uniqueId: {}", viewProductRequestDto.getProductId());
            throw new ResourceNotFoundException("Product not found with uniqueId: " + viewProductRequestDto.getProductId());
        }
            //map and view

            ViewProductResponseDto productDto = productMapper.entityToviewDetails(product.get());
            log.info("Product retrieved successfully with name: ");
        ApiResponse<?> response = new ApiResponse<>(true, "User details fetched successfully", 200,productDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }
}
