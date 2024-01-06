package com.example.project2.models;

import com.example.project2.entities.AuthorEntity;
import com.example.project2.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
@Data
public class Category {
    private Integer id;
    private String name;
    private List<ProductEntity> products;
    private AuthorEntity author;
}
