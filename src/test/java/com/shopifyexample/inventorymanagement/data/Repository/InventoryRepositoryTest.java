package com.shopifyexample.inventorymanagement.data.Repository;

import com.shopifyexample.inventorymanagement.data.model.Inventory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Slf4j
class InventoryRepositoryTest {

    @Autowired
    InventoryRepository inventoryRepositoryImpl;


    @Test
    void createIncomingStock(){
        Inventory inventory = new Inventory();
        inventory.setProductName("Hp Pavilion");
        inventory.setBrand("HP");
        inventory.setProductCategory("Electronics");
        inventory.setPrice(70000.00);

        assertThat(inventory.getId()).isNull();
        log.info("incomingStock before saving -> {}", inventory);
        inventoryRepositoryImpl.save(inventory);
        assertThat(inventory.getId()).isNotNull();
        log.info("incomingStock after saving -> {}", inventory);
    }

    @Test
    void testThatIncomingStockCanBeFoundById(){
        Inventory stock = inventoryRepositoryImpl.findById(1L).orElse(null);
        assertThat(stock).isNotNull();
        log.info("Found incoming stock -> {}", stock);
    }

    @Test
    void testThatAllIncomingStockCanBeFound(){
        List<Inventory> stocks = inventoryRepositoryImpl.findAll();
        assertThat(stocks).isNotNull();
        log.info("Found incoming stock -> {}", stocks);
    }

}