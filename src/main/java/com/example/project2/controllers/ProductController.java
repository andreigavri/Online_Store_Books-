package com.example.project2.controllers;

import com.example.project2.entities.ProductEntity;
import com.example.project2.models.Product;
import com.example.project2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productServiceImpl) {
        this.productService = productServiceImpl;
    }

    @PostMapping("/classics")
    public Product createNewClassicsProduct(@RequestBody Product product) {
        return productService.createClassicsProduct(product);
    }

    @PostMapping("/history")
    public Product createNewHistoryProduct(@RequestBody Product product) {
        return productService.createHistoryProduct(product);
    }

    @GetMapping("/allProducts")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("title/{title}")
    public Product getProductByTitle(@PathVariable String title) {
        return productService.getProductByTitle(title);
    }

    @GetMapping("description/{description}")
    public Product getProductByDescription(@PathVariable String description) {
        return productService.getProductByDescription(description);
    }

    @PutMapping("/{id}")
    public Product updateProductDetails(@PathVariable Integer id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping
    public ResponseEntity deleteAllProducts() {
        productService.deleteAllProducts();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsersById(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}



