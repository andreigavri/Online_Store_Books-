package com.example.project2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Product {
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private ProductCategory category;
    private Integer authorId;
}
