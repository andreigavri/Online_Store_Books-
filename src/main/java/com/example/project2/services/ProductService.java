package com.example.project2.services;

import com.example.project2.entities.ProductEntity;
import com.example.project2.models.Product;


import java.util.List;

public interface ProductService {
    //Create
    Product createClassicsProduct(Product product);
    Product createHistoryProduct(Product product);

    //READ
    Product getProductByTitle(String title);

    List<ProductEntity> getAllProducts();

    Product getProductById(Integer id);

    Product getProductByDescription(String description);

    //UPDATE
    Product updateProduct(Integer id, Product product);

    //DELETE
    void deleteProductById(Integer id);

    void deleteAllProducts();
}

