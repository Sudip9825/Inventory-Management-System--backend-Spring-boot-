package com.sudip.application.Inventory.Management.System.repository;

import com.sudip.application.Inventory.Management.System.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
 @Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByUniqueId(String uniqueId);
    Optional<Product> findByProductName( String productName);
    Optional<Product> findByUniqueId(String uniqueId);
     Optional<Product> findById(Integer ProductId);
    Page<Product> findAll(Pageable pageable);

    @Query("""
            SELECT p FROM Product p
            WHERE (:keyword IS NULL OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%')))
               OR (:keyword IS NULL OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%')))
        """)
    Page<Product> searchProduct(String keyword, Pageable pageable);


}
