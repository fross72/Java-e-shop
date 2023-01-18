package com.fross72.ecommerce.controllers;

import com.fross72.ecommerce.models.Product;
import com.fross72.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String home(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/add")
    public String addProducts(Model model){
        return "product-add";
    }

    @PostMapping("/product/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam int price,
                             @RequestParam String imageURL,
                             @RequestParam String description,
                             Model model){
        Product product = new Product(name,description,price,imageURL);
        productService.saveProduct(product);
        return "product-add";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "shop";
    }

    @GetMapping("/shop/{id}")
    public String product(@PathVariable UUID id, Model model){
        Optional<Product> optionalProduct = productService.getProductById(id);
        if(!optionalProduct.isPresent()){
            return "redirect:/";
        }
        Product product = optionalProduct.get();
        List<Product> products = productService.getFirstNProducts(4);
        model.addAttribute("product", product);
        model.addAttribute("products", products);
        return "s-product";
    }

}
