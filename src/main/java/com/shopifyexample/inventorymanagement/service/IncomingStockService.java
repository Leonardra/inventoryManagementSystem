package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.dto.IncomingStockRequestDto;
import com.shopifyexample.inventorymanagement.data.dto.IncomingStockResponseDto;
import org.springframework.stereotype.Service;


@Service
public interface IncomingStockService {
    IncomingStockResponseDto addProduct(IncomingStockRequestDto product);
    IncomingStockResponseDto deleteProduct(Long productId);
}
