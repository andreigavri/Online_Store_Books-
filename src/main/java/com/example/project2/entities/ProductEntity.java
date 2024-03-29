package com.example.project2.entities;

import com.example.project2.models.ProductCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name ="_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", nullable = false, updatable = true)
    private String title;
    @Column(name = "description", nullable = false, updatable = true)
    private String description;
    @Column(name = "price", nullable = false, updatable = true)
    private Double price;
    @Enumerated(EnumType.STRING)
    @Column(name= "product_category",nullable = false)
    private ProductCategory category;
    @ManyToOne
    @JoinColumn(name ="author_id")
    @JsonBackReference
    private AuthorEntity auth;
    @ManyToMany(mappedBy ="products")
    @JsonBackReference
    private List<OrderEntity> orders;

}
