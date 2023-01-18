package com.fross72.ecommerce.services;

import com.fross72.ecommerce.models.Product;
import com.fross72.ecommerce.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getFirstNProducts(int n) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        int i = 0;
        while(i!=n && i!=allProducts.size()){
            products.add(allProducts.get(i));
            i++;
        }
        return products;
    }
}
