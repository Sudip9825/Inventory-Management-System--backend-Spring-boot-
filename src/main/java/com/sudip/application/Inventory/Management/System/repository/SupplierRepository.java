package com.sudip.application.Inventory.Management.System.repository;

import com.sudip.application.Inventory.Management.System.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<Supplier> findByEmail(String email);
    Optional<Supplier> findById(Integer id);


    @Query("SELECT s From Supplier s WHERE s.isDeleted = false")
    Page<Supplier> findAll(Pageable pageable);

    @Query("""
                SELECT s FROM Supplier s
                WHERE (:keyword IS NULL OR LOWER(s.SupplierName) LIKE LOWER(CONCAT('%', :keyword, '%')))
                   OR (:keyword IS NULL OR LOWER(s.email) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    Page<Supplier> searchSupplier(String keyword, Pageable pageable);


}
