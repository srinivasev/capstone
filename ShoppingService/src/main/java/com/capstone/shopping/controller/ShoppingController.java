package com.capstone.shopping.controller;

import com.capstone.shopping.model.ProductDTO;
import com.capstone.shopping.service.ShoppingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @PostMapping("/shoppingservice/products")
    public Mono<ProductDTO> addProduct(@RequestBody ProductDTO productDTO){

        Mono<ProductDTO> productDTOSaved = shoppingService.saveProductDetails(productDTO);
        /*productDTOSaved.subscribe(
                productDTO1 -> {
                    System.out.println("printing product details" + productDTO1.getProductId());
                    System.out.println("printing product details" + productDTO1.getProductName());
                    System.out.println("printing product details" + productDTO1.getProductDescription());
                }
        );*/
        System.out.println("productDTOSaved" + productDTOSaved);
        productDTOSaved.block();

        //invoke inventory service
        Mono<ProductDTO> inventorySaved = shoppingService.saveProductInventoryDetails(productDTO);
        System.out.println("productDTOSaved" + productDTOSaved);
        return inventorySaved;
    }
}
