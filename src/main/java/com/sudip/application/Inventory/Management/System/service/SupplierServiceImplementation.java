package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.core.dto.ApiResponse;
import com.sudip.application.Inventory.Management.System.core.dto.PaginationDto;
import com.sudip.application.Inventory.Management.System.core.service.EmailTemplateService;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.DeleteSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.ListSupplierResponseDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.RegisterSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.dto.supplierdto.UpdateSupplierRequestDto;
import com.sudip.application.Inventory.Management.System.entity.Supplier;
import com.sudip.application.Inventory.Management.System.exception.handler.DuplicateException;
import com.sudip.application.Inventory.Management.System.exception.handler.ResourceNotFoundException;
import com.sudip.application.Inventory.Management.System.mapper.SupplierMapper;
import com.sudip.application.Inventory.Management.System.repository.SupplierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class SupplierServiceImplementation implements SupplierService{
   private static final Logger log = LoggerFactory.getLogger(SupplierServiceImplementation.class);

   @Autowired
    private SupplierRepository supplierRepository;

   @Autowired
   private SupplierMapper supplierMapper;

    @Autowired
    private EmailTemplateService emailTemplateService;

    @Transactional
    @Override
    @CacheEvict(value ="users",allEntries = true)
    public ApiResponse<?> saveSupplier(RegisterSupplierRequestDto registerSupplierRequestDto) {
        if (supplierRepository.existsByEmail(registerSupplierRequestDto.getEmail())) {
            log.error("Email already exists");
            throw  new DuplicateException( "Email already exists");
        }
        Supplier supplier = supplierMapper.createSupplier(registerSupplierRequestDto);
        emailTemplateService.sendWelcomeMail(supplier);
        supplierRepository.save(supplier);
        log.info("Supplier saved successfully");

        return new ApiResponse<>( true,"Supplier saved",201, supplier);

    }

    @Cacheable (
            value = "users",
            key = "#paginationDto.page + '-' + #paginationDto.size + '-' + (#paginationDto.keyword != null ? #paginationDto.keyword : '')"
    )
    @Override
    public ApiResponse<?> listSupplier(PaginationDto paginationDto) {
        Pageable pageable = PageRequest.of(paginationDto.getPage(), paginationDto.getSize() , Sort.by(Sort.Direction.DESC, "id"));
       Page<Supplier> supplierPage;
        if (paginationDto.getKeyword()!=null  && !paginationDto.getKeyword().trim().isEmpty()) {
            supplierPage= supplierRepository.searchSupplier(paginationDto.getKeyword().trim(), pageable);
        }
        else {
            supplierPage= supplierRepository.findAll(pageable);
        }

        List<ListSupplierResponseDto> listSupplierResponseDto = supplierMapper.ListAllSuppliers(supplierPage);
         return new ApiResponse<>(true, "user listed successfully", 200, LocalDateTime.now(),listSupplierResponseDto);

    }

    @Override
    public ResponseEntity<ApiResponse<?>> deleteSupplier(DeleteSupplierRequestDto deleteSupplierRequestDto) {
        Optional<Supplier> supplier =supplierRepository.findById(deleteSupplierRequestDto.getId());
        if (supplier.isEmpty()) {
            log.error("User with id {} not found", deleteSupplierRequestDto.getId());
            throw new ResourceNotFoundException("User with id " + deleteSupplierRequestDto.getId() + " not found");
        }
        Supplier supplierToDelete = supplierMapper.deleteSupplier(supplier.get());
        supplierRepository.save(supplierToDelete);
        ApiResponse<?> response = new ApiResponse<>(true, "User deleted successfully", 200);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<ApiResponse<?>> updateSupplier(UpdateSupplierRequestDto updateSupplierRequestDto) {
        Optional<Supplier> supplierOptional =supplierRepository.findById(updateSupplierRequestDto.getId());
        boolean existsByEmail = supplierRepository.existsByEmail(updateSupplierRequestDto.getEmail());
        if (existsByEmail) {
            throw new DuplicateException("Email already exists");
        }
        boolean existsByPhone = supplierRepository.existsByPhoneNumber(updateSupplierRequestDto.getPhoneNumber());
        if (existsByPhone) {
            throw new DuplicateException("Phone already exists");
        }
        Supplier existingSupplier = supplierOptional.get();

        Supplier SupplierToUpdate = supplierMapper.updateSupplier(existingSupplier, updateSupplierRequestDto);
        supplierRepository.save(SupplierToUpdate);
        log.info("Supplier updated successfully");
        ApiResponse<?> response = new ApiResponse<>(true, "Supplier updated successfully", 200);
       return  ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
