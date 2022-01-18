package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.dto.InventoryRequestDto;
import com.shopifyexample.inventorymanagement.data.dto.InventoryResponseDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public interface InventoryService {
    InventoryResponseDto addInventory(InventoryRequestDto product);
    InventoryResponseDto findById(Long productId);
    List<InventoryResponseDto> findAll();
    void deleteInventory(Long productId);
    void updateInventory(Long id, InventoryRequestDto incomingStock);
    void writeToCsv() throws IOException;
}
