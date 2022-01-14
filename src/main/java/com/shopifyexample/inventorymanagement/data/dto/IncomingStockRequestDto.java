package com.shopifyexample.inventorymanagement.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class IncomingStockRequestDto {
    private String productName;
    private String brand;
    private String productCategory;
    private Double price;
    private int quantity;
}
