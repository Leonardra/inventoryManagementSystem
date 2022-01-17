package com.shopifyexample.inventorymanagement.data.Repository;

import com.shopifyexample.inventorymanagement.data.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
