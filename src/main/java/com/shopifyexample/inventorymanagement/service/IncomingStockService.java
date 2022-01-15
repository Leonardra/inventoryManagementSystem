package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.dto.IncomingStockRequestDto;
import com.shopifyexample.inventorymanagement.data.dto.IncomingStockResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IncomingStockService {
    IncomingStockResponseDto addProduct(IncomingStockRequestDto product);
    IncomingStockResponseDto findById(Long productId);
    List<IncomingStockResponseDto> findAll();
}
