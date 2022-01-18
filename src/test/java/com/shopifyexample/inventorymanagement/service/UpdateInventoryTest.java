package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.Repository.InventoryRepository;
import com.shopifyexample.inventorymanagement.data.dto.InventoryRequestDto;
import com.shopifyexample.inventorymanagement.data.model.Inventory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class UpdateInventoryTest {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    InventoryRepository inventoryRepository;

    @Test
    void updateInventory(){
        Inventory item = inventoryRepository.findById(1L).orElse(null);
        assertThat(item).isNotNull();
        InventoryRequestDto incomingStock2 = new InventoryRequestDto(
                "Hp EliteBook",
                "Hp",
                "Computer",
                12000.00,
                10
        );

        inventoryService.updateInventory(1L, incomingStock2);
        assertThat(item.getProductCategory()).isEqualTo(incomingStock2.getProductCategory());
        assertThat(item.getPrice()).isEqualTo(12000);
    }
}
