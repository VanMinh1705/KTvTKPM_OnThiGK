package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;

import java.util.List;

@RestController()
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("products")
    List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }
}
