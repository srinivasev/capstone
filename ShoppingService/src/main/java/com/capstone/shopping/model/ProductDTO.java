package com.capstone.shopping.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    private int productId;

    private String productName;

    private String productDescription;

    @NotNull
    private long productPrice;

    private int quantity;
}
