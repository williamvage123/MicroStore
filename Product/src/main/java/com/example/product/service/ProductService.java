package com.example.product.service;

import com.example.product.model.ProductModel;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();  // Fetches all products from DB when ready
    }

    // Create a new product
    public ProductModel createProduct(ProductModel productModel) {
        return productRepository.save(productModel);  // Saves product to DB (or in-memory if H2)
    }

    // Find a product by ID
    public ProductModel getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Delete a product by ID
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
