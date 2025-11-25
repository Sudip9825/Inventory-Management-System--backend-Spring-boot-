package com.sudip.application.Inventory.Management.System.mapper;

import com.sudip.application.Inventory.Management.System.dto.supplierdto.ListSupplierResponseDto;
import com.sudip.application.Inventory.Management.System.entity.Supplier;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-25T12:39:23+0545",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class SupplierMapperImpl extends SupplierMapper {

    @Override
    public ListSupplierResponseDto entityToResponseDto(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        ListSupplierResponseDto listSupplierResponseDto = new ListSupplierResponseDto();

        listSupplierResponseDto.setId( supplier.getId() );
        listSupplierResponseDto.setSupplierName( supplier.getSupplierName() );
        listSupplierResponseDto.setEmail( supplier.getEmail() );
        listSupplierResponseDto.setPhoneNumber( supplier.getPhoneNumber() );
        listSupplierResponseDto.setAddress( supplier.getAddress() );
        listSupplierResponseDto.setCreatedAt( supplier.getCreatedAt() );
        listSupplierResponseDto.setUpdatedAt( supplier.getUpdatedAt() );

        return listSupplierResponseDto;
    }
}
