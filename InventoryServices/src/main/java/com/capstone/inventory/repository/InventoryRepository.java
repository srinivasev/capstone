package com.capstone.inventory.repository;

import com.capstone.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {


    Inventory findByProductId(int productId);

    void deleteByProductId(int productId);

}
