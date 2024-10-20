package com.capstone.shopping.service;


import com.capstone.shopping.model.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ShoppingService {

    private WebClient webClient = WebClient.create();

    public Mono<ProductDTO> saveProductDetails(ProductDTO productDTO){

        return webClient.post().uri("http://localhost:8080/api/products").bodyValue(productDTO).
                retrieve().
                bodyToMono(ProductDTO.class);

    }

    public Mono<ProductDTO> saveProductInventoryDetails(ProductDTO productDTO){
        return webClient.post().uri("http://localhost:8080/api/inventory").bodyValue(productDTO).
                retrieve().
                bodyToMono(ProductDTO.class);

    }
}
