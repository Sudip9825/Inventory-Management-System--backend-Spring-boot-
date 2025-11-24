package com.sudip.application.Inventory.Management.System.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name="products")
@EntityListeners(AuditingEntityListener.class)
@SQLRestriction("is_deleted = false")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;

    @Column(name="name" ,nullable=false,length=100)
    private String productName;

    @Column(name="category")
    private String category;

    @Column(name ="price" ,nullable=false,length=100)
    private Double price;

    @Column(name="quantity")
    private Integer quantity;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt  ;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;


    @Column(name = "is_deleted", nullable = false)
    private boolean IsDeleted = false;

    @Column(name="unique_id",nullable=false)
    private String uniqueId;

    @ManyToOne(optional = false)
    @JoinColumn(name="supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    @Column(name="product_picture", nullable = false)
    private String productPicture;

}
