package com.fross72.ecommerce.services;

import com.fross72.ecommerce.models.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(UUID id);
    List<Product> getFirstNProducts(int n);
}
