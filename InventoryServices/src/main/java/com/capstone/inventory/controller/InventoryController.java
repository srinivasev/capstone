package com.capstone.inventory.controller;

import com.capstone.inventory.model.Inventory;
import com.capstone.inventory.model.InventoryDTO;
import com.capstone.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("/api/inventory/{productId}")
    public ResponseEntity<InventoryDTO> getInventory(@PathVariable("productId") int productId){

        return new ResponseEntity<>(inventoryService.getInventory(productId), HttpStatus.OK);
    }

    @PostMapping("/api/inventory")
    public ResponseEntity<InventoryDTO> addInventory(@RequestBody
                                                     InventoryDTO inventoryDTO){

        return new ResponseEntity<>(inventoryService.saveInventory(inventoryDTO), HttpStatus.OK);
    }

    @PutMapping("/api/inventory")
    public ResponseEntity<InventoryDTO> updateInventory(@RequestBody
                                                     InventoryDTO inventoryDTO){

        return new ResponseEntity<>(inventoryService.updateInventory(inventoryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/api/inventory/{productId}")
    public ResponseEntity deleteInventory(@PathVariable int productId){
        inventoryService.deleteInventory(productId);
        return ResponseEntity.ok().build();
    }

}
