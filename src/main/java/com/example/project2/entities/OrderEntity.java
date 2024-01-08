package com.example.project2.entities;

import com.example.project2.models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number_of_products", nullable = false, updatable = true)
    private Integer numberOfProducts;
    @Column(name = "total_cost", nullable = false, updatable = true)
    private Double totalCost;
    @Column(name = "delivery_address", nullable = true, updatable = true)
    private String deliveryAddress;
    @Column(name = "date_of_submission", nullable = true, updatable = true)
    private String dateOfSubmission;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;
    @ManyToMany
    private List<ProductEntity> products;
}

