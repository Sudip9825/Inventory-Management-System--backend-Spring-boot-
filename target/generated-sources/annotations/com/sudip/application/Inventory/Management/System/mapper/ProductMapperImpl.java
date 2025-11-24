package com.sudip.application.Inventory.Management.System.mapper;

import com.sudip.application.Inventory.Management.System.dto.productdto.ListProductResponseDto;
import com.sudip.application.Inventory.Management.System.dto.productdto.ViewProductResponseDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.SupplierModel;
import com.sudip.application.Inventory.Management.System.entity.Product;
import com.sudip.application.Inventory.Management.System.entity.Supplier;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T11:35:33+0545",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl extends ProductMapper {

    @Override
    public ListProductResponseDto entityToResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ListProductResponseDto listProductResponseDto = new ListProductResponseDto();

        listProductResponseDto.setProductName( product.getProductName() );
        listProductResponseDto.setCategory( product.getCategory() );
        listProductResponseDto.setPrice( product.getPrice() );
        listProductResponseDto.setQuantity( product.getQuantity() );
        listProductResponseDto.setCreatedAt( product.getCreatedAt() );
        listProductResponseDto.setUpdatedAt( product.getUpdatedAt() );
        listProductResponseDto.setUniqueId( product.getUniqueId() );
        listProductResponseDto.setSupplier( supplierToSupplierModel( product.getSupplier() ) );

        return listProductResponseDto;
    }

    @Override
    public ViewProductResponseDto entityToviewDetails(Product product) {
        if ( product == null ) {
            return null;
        }

        ViewProductResponseDto viewProductResponseDto = new ViewProductResponseDto();

        viewProductResponseDto.setProductName( product.getProductName() );
        viewProductResponseDto.setCategory( product.getCategory() );
        viewProductResponseDto.setPrice( product.getPrice() );
        viewProductResponseDto.setQuantity( product.getQuantity() );
        viewProductResponseDto.setCreatedAt( product.getCreatedAt() );
        viewProductResponseDto.setUpdatedAt( product.getUpdatedAt() );
        viewProductResponseDto.setUniqueId( product.getUniqueId() );
        viewProductResponseDto.setSupplier( product.getSupplier() );

        return viewProductResponseDto;
    }

    protected SupplierModel supplierToSupplierModel(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierModel supplierModel = new SupplierModel();

        supplierModel.setSupplierName( supplier.getSupplierName() );

        return supplierModel;
    }
}
