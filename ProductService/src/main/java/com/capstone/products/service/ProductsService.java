package com.capstone.products.service;

import com.capstone.products.entity.Product;
import com.capstone.products.model.ProductDTO;
import com.capstone.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO getProduct(int productId) {
        System.out.println("Fetching the Product from repository" + productId);
        return convertProductToProductDTO(productRepository.findById(productId));
    }

    private ProductDTO convertProductToProductDTO(Optional<Product> product) {
        if (product.isPresent()) {
            ProductDTO productDTO = new ProductDTO(product.get().getProductId(),
                    product.get().getProductName(),
                    product.get().getProductDescription(),
                    product.get().getProductPrice());
            return productDTO;
        }
        throw new RuntimeException("Product with id provided is not found");
    }

    private Product convertDTOtoProduct(Optional<ProductDTO> productDTO){
        if(productDTO.isPresent()){
            Product product = new Product();
            product.setProductName(productDTO.get().getProductName());
            product.setProductPrice(productDTO.get().getProductPrice());
            product.setProductDescription(productDTO.get().getProductDescription());
            return product;
        }
        throw new RuntimeException("Incomplete DTO for processing ");
    }

    public ProductDTO persistProduct(ProductDTO productDTO) {
        Product product = convertDTOtoProduct(Optional.ofNullable(productDTO));
        Product updatedProduct = productRepository.save(product);
        return convertProductToProductDTO(Optional.of(updatedProduct));
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = convertDTOtoProduct(Optional.ofNullable(productDTO));
        if(productDTO.getProductId() != 0){
            product.setProductId(productDTO.getProductId());
        }
        Product updatedProduct = productRepository.save(product);
        return convertProductToProductDTO(Optional.of(updatedProduct));
    }

    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}
