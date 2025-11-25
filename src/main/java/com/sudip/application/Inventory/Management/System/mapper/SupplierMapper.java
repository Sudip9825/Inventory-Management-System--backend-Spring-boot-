package com.sudip.application.Inventory.Management.System.mapper;

import com.sudip.application.Inventory.Management.System.dto.supplierdto.ListSupplierResponseDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.RegisterSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.UpdateSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public abstract class SupplierMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;  // Let Spring inject it

    // Mapper to create new supplier
    public Supplier createSupplier(RegisterSupplierRequestDto registerSupplierRequestDto) {
        Supplier supplier = new Supplier();
        String uniqueId = String.valueOf(UUID.randomUUID());
        supplier.setSupplierName(registerSupplierRequestDto.getSupplierName());
        supplier.setPassword(passwordEncoder.encode(registerSupplierRequestDto.getPassword()));
        supplier.setEmail(registerSupplierRequestDto.getEmail());
        supplier.setAddress(registerSupplierRequestDto.getAddress());
        supplier.setPhoneNumber(registerSupplierRequestDto.getPhoneNumber());
        supplier.setUniqueId(uniqueId);
        supplier.setRole("USER");
        return supplier;
    }

    // Mapper method to list Supplier
    public abstract ListSupplierResponseDto entityToResponseDto(Supplier supplier);

    public List<ListSupplierResponseDto> ListAllSuppliers(Page<Supplier> suppliers) {
        return suppliers.getContent()
                .stream()
                .map(this::entityToResponseDto)
                .collect(Collectors.toList());
    }

    // Mapper to delete
    public Supplier deleteSupplier(Supplier supplier) {
        supplier.setDeleted(true);
        return supplier;
    }

    // Mapper to update
    public Supplier updateSupplier(Supplier supplier, UpdateSupplierRequestDto updateSupplierRequestDto) {
        supplier.setSupplierName(updateSupplierRequestDto.getSupplierName());
        supplier.setEmail(updateSupplierRequestDto.getEmail());
        supplier.setPhoneNumber(updateSupplierRequestDto.getPhoneNumber());
        return supplier;
    }
}