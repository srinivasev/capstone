package com.capstone.inventory.service;

import com.capstone.inventory.model.Inventory;
import com.capstone.inventory.model.InventoryDTO;
import com.capstone.inventory.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }
    public InventoryDTO getInventory(int productId) {
        Optional<Inventory> inventory = Optional.ofNullable(inventoryRepository.findByProductId(productId));
        return convertInventoryToDTO(inventory.get());
    }

    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {

        Inventory inventoryToPersist = convertDTOtoInventory(inventoryDTO);
        System.out.println("Displying invetory to persist data " + inventoryToPersist.getInventoryId() + inventoryToPersist.getQuantity() + inventoryToPersist.getProductId());
        Inventory savedInventory = inventoryRepository.save(inventoryToPersist);
        return convertInventoryToDTO(savedInventory);
    }

    public InventoryDTO updateInventory(InventoryDTO inventoryDTO){

        Inventory inventoryInDB = inventoryRepository.findByProductId(inventoryDTO.getProductId());
        inventoryInDB.setQuantity(inventoryDTO.getQuantity());

        Inventory savedInventory = inventoryRepository.save(inventoryInDB);
        return convertInventoryToDTO(savedInventory);
    }
    @Transactional
    public void deleteInventory(int productId){
        inventoryRepository.deleteByProductId(productId);
    }

    private InventoryDTO convertInventoryToDTO(Inventory inventory){
        InventoryDTO inventoryDTO = new InventoryDTO();
        if(inventory != null){
            inventoryDTO.setInventoryId(inventory.getInventoryId());
            inventoryDTO.setProductId(inventory.getProductId());
            inventoryDTO.setQuantity(inventory.getQuantity());
            return inventoryDTO;
        }
        throw new RuntimeException("Inventory details are not available");
    }

    private Inventory convertDTOtoInventory(InventoryDTO inventoryDTO){
        Inventory inventory = new Inventory();
        /*if(inventoryDTO.getInventoryId()!=0) {
            inventory.setInventoryId(inventoryDTO.getInventoryId());
        }*/
        inventory.setProductId(inventoryDTO.getProductId());
        inventory.setQuantity(inventoryDTO.getQuantity());
        return inventory;
    }

}
