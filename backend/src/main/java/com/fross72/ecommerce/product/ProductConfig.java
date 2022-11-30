package com.fross72.ecommerce.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner1(ProductRepository  productRepository){
        return args -> {
          Product tShirt =  new Product("T shirt", "cozy T shirt", "#");
          productRepository.saveAll(List.of(tShirt));
        };
    }
}
