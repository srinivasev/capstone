package com.capstone.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "INVENTORY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "INVENTORY_SEQ")
    @SequenceGenerator(name = "INVENTORY_SEQ",
            sequenceName = "INVENTORY_SEQ",
            allocationSize = 1)
    @Column(name = "INVENTORY_ID")
    private int inventoryId;

    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "QUANTITY")
    private int quantity;
}
