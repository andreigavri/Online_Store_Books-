package com.example.project2.repositories;

import com.example.project2.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
     ProductEntity findByTitle(String title);
     ProductEntity findByDescription(String description);
}
