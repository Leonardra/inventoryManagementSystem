package com.shopifyexample.inventorymanagement.service;


import com.shopifyexample.inventorymanagement.data.Repository.InventoryRepository;
import com.shopifyexample.inventorymanagement.data.dto.InventoryRequestDto;
import com.shopifyexample.inventorymanagement.data.dto.InventoryResponseDto;
import com.shopifyexample.inventorymanagement.data.model.Inventory;
import com.shopifyexample.inventorymanagement.exception.InventoryException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class InventoryServiceImplTest {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private InventoryRepository inventoryRepository;

    private InventoryRequestDto inventory;
    private InventoryRequestDto inventory2;
    @BeforeEach
    void setUp() {
        inventory = new InventoryRequestDto();
        inventory.setProductName("Laptop");
        inventory.setBrand("Hp");
        inventory.setProductCategory("Electronics");
        inventory.setPrice(400000.00);

        inventory2 = new InventoryRequestDto();
        inventory2.setProductName("Refrigerator");
        inventory2.setBrand("Heier Thermocool");
        inventory2.setProductCategory("Household");
        inventory2.setPrice(60000.00);

        inventoryService.addInventory(inventory);
        inventoryService.addInventory(inventory2);

    }

    @AfterEach
    void tearDown() {
        inventoryRepository.deleteAll();
    }

    @Test
    @DisplayName("Test should pass if an inventory is added successfully")
    void testThatInventoryCanBeAdded(){
        InventoryRequestDto inventory3 = new InventoryRequestDto();
        inventory3.setProductName("Laptop");
        inventory3.setBrand("Hp");
        inventory3.setProductCategory("Electronics");
        inventory3.setPrice(400000.00);
        inventoryService.addInventory(inventory3);
        assertThat(inventoryRepository.findAll().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Test should pass if a null pointer exception is thrown")
    void testThatInventoryCannotBeNull(){
        InventoryRequestDto inventory = null;
        assertThrows(NullPointerException.class, ()->inventoryService.addInventory(inventory));
    }


    @Test
    @DisplayName("Test should pass if database doesn't save inventory without product name")
    void testThatInventoryCannotHaveEmptyProductName(){
        InventoryRequestDto inventory3 = new InventoryRequestDto();
        inventory3.setProductName("");
        inventory3.setBrand("Hp");
        inventory3.setProductCategory("Electronics");
        inventory3.setPrice(400000.00);
        assertThrows(InventoryException.class, ()->inventoryService.addInventory(inventory3));
        assertThat(inventoryRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test should pass if database doesn't save inventory without product category")
    void testThatInventoryCannotHaveEmptyProductCategory(){
        InventoryRequestDto inventory3 = new InventoryRequestDto();
        inventory3.setProductName("Laptop");
        inventory3.setBrand("Hp");
        inventory3.setProductCategory("");
        inventory3.setPrice(400000.00);
        assertThrows(InventoryException.class, ()->inventoryService.addInventory(inventory3));
        assertThat(inventoryRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test should pass if inventory is found successfully")
    void testThatInventoryCanBeFoundById(){
        InventoryResponseDto inventory = inventoryService.findById(1L);
        assertThat(inventory).isNotNull();
    }

    @Test
    @DisplayName("Test should pass if an exception is thrown when an inventory id is invalid")
    void testThatAnExceptionIsThrownIfIdIsInvalid(){
        assertThrows(IllegalArgumentException.class, ()->inventoryService.findById(4L));
    }

    @Test
    @DisplayName("Test should pass if inventory id can't be found after successful deletion")
    void testThatInventoryCanBeDeleted(){
        InventoryRequestDto inventory3 = new InventoryRequestDto();
        inventory3.setProductName("Laptop");
        inventory3.setBrand("Hp");
        inventory3.setProductCategory("Electronic");
        inventory3.setPrice(400000.00);
        inventoryService.addInventory(inventory3);
        assertThat(inventoryService.findById(3L)).isNotNull();
        inventoryService.deleteInventory(3L);
        assertThrows(IllegalArgumentException.class, ()->inventoryService.findById(3L));
    }


    @Test
    void testThatInventoryCanBeUpdated() {
        InventoryRequestDto inventory3 = new InventoryRequestDto();
        inventory3.setProductName("Laptop");
        inventory3.setBrand("Hp");
        inventory3.setProductCategory("Electronic");
        inventory3.setPrice(400000.00);
        assertThat(inventory2.getProductCategory()).isEqualTo("Household");
        inventoryService.updateInventory(2L, inventory3);
        assertThat(inventoryService.findById(2L).getProductCategory()).isEqualTo("Electronic");
    }

}
