package com.shopifyexample.inventorymanagement.data.Repository;

import com.shopifyexample.inventorymanagement.data.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {

}
