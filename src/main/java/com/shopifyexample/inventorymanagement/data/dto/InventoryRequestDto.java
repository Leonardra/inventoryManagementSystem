package com.shopifyexample.inventorymanagement.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestDto {
    private String productName;
    private String brand;
    private String productCategory;
    private Double price;
}
