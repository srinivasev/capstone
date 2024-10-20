package com.capstone.products.controller;

import com.capstone.products.model.ProductDTO;
import com.capstone.products.service.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductsController {

    private ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("productId") int productId){
        System.out.println("Fetching the Product in controller " + productId);
        return ResponseEntity.ok(productsService.getProduct(productId));
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO product){
        return ResponseEntity.ok(productsService.persistProduct(product));
    }

    @PutMapping("/products")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product){
        return ResponseEntity.ok(productsService.updateProduct(product));
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId){
        productsService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
