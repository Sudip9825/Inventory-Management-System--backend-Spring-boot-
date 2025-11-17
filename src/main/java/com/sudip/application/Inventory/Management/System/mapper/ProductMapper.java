package com.sudip.application.Inventory.Management.System.mapper;

import com.sudip.application.Inventory.Management.System.dto.productdto.ListProductResponseDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.RegisterProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.UpdateProductRequestDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.ViewProductResponseDto;
import com.sudip.application.Inventory.Management.System.entity.Product;
import com.sudip.application.Inventory.Management.System.entity.Supplier;
import com.sudip.application.Inventory.Management.System.exception.handler.ResourceNotFoundException;
import com.sudip.application.Inventory.Management.System.repository.SupplierRepository;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel= MappingConstants.ComponentModel.SPRING)


public  abstract class ProductMapper {
    @Autowired
    private SupplierRepository supplierRepository;

    public Product createProduct(RegisterProductRequestDto registerProductRequestDto) {
        String  uniqueId = String.valueOf(UUID.randomUUID());

        Optional<Supplier> supplier = supplierRepository.findById(registerProductRequestDto.getSupplierId());
        if(supplier.isEmpty()){
            throw  new ResourceNotFoundException("Supplier Not Found");
        }

        Product product = new Product();
        product.setProductName(registerProductRequestDto.getProductName());
        product.setCategory(registerProductRequestDto.getCategory());
        product.setPrice(registerProductRequestDto.getPrice());
        product.setQuantity(registerProductRequestDto.getQuantity());
        product.setSupplier(supplier.get());
        product.setUniqueId(uniqueId);
        return product;
    }

 //mapper for list product
    public abstract ListProductResponseDto entityToResponse(Product product);
    public List<ListProductResponseDto> listAllProduct(Page<Product> products) {
        return products.getContent().stream().map(this::entityToResponse).collect(Collectors.toList());


  }
    // mapper for update
    public Product updateProduct(Product product, UpdateProductRequestDto updateProductRequestDto) {
        product.setProductName(updateProductRequestDto.getProductName());
        product.setCategory(updateProductRequestDto.getCategory());
        return product;
    }
    //mapper method to delete user
    public  Product deleteProduct(Product product) {
        product.setIsDeleted(true);
        return product;
    }
    //mapper method to view user
    public abstract ViewProductResponseDto entityToviewDetails(Product product);
}

