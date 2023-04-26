package com.example.homework_29_spring_security.controllers;

import com.example.homework_29_spring_security.entity.Product;
import com.example.homework_29_spring_security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id){
        return productService.getProductById(id).toString();
    }
    @PostMapping
    public Product addProduct(Product product){
        return productService.saveNewProduct(product);
    }
    @DeleteMapping
    public void deleteProduct(Product product){
        productService.deleteProduct(product);
    }
}
