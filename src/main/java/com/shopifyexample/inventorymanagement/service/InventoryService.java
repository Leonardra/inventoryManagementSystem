package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.dto.InventoryRequestDto;
import com.shopifyexample.inventorymanagement.data.dto.InventoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface InventoryService {
    InventoryResponseDto addProduct(InventoryRequestDto product);
    InventoryResponseDto findById(Long productId);
    List<InventoryResponseDto> findAll();
    void deleteProduct(Long productId);
    void update(Long id, InventoryRequestDto incomingStock);
}
