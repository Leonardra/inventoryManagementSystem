package com.shopifyexample.inventorymanagement.data.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private int stockQuantity;
    private boolean isInStock;
    @UpdateTimestamp
    private LocalDate updatedDate;
}
