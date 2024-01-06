package com.example.project2.models;

import com.example.project2.entities.AuthorEntity;
import com.example.project2.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private AuthorEntity auth;
    private CategoryEntity categoryEntity;
}
