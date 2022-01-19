package com.shopifyexample.inventorymanagement.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponseDto {
    private Long id;
    private String productName;
    private String brand;
    private String productCategory;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
