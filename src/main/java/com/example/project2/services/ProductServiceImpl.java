package com.example.project2.services;

import com.example.project2.entities.ProductEntity;
import com.example.project2.models.Product;
import com.example.project2.models.ProductCategory;
import com.example.project2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product createClassicsProduct(Product product) {
        product.setCategory(ProductCategory.CLASSICS);
        ProductEntity productEntityToSaveInDb = ProductEntity.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
        productRepository.save(productEntityToSaveInDb);
        product.setId(productEntityToSaveInDb.getId());
        return product;
    }
    @Override
    public Product createHistoryProduct(Product product) {
        product.setCategory(ProductCategory.HISTORY);
        ProductEntity productEntityToSaveInDb = ProductEntity.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
        productRepository.save(productEntityToSaveInDb);
        product.setId(productEntityToSaveInDb.getId());
        return product;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByTitle(String title) {
        ProductEntity entity = productRepository.findByTitle(title);
        Product productToReturnFromDb = Product.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .category(entity.getCategory())
                .build();
        return productToReturnFromDb;
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<ProductEntity> optionalEntity = productRepository.findById(id);
        if (optionalEntity.isPresent()) {
            ProductEntity entity = optionalEntity.get();
            return Product.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .description(entity.getDescription())
                    .price(entity.getPrice())
                    .category(entity.getCategory())
                    .build();
        }
        return null;
    }

    @Override
    public Product getProductByDescription(String description) {
        ProductEntity entity = productRepository.findByDescription(description);
        Product productToReturnFromDb = Product.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .category(entity.getCategory())
                .build();
        return productToReturnFromDb;
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        Optional<ProductEntity> foundProduct = productRepository.findById(id);
        if (foundProduct.isPresent()) {
            ProductEntity productToUpdate = foundProduct.get();
            productToUpdate.setTitle(product.getTitle());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setCategory(product.getCategory());
            productRepository.save(productToUpdate);
            return product;
        }
        return null;
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
