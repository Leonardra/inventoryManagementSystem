package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.Repository.IncomingStockRepository;
import com.shopifyexample.inventorymanagement.data.dto.IncomingStockRequestDto;
import com.shopifyexample.inventorymanagement.data.dto.IncomingStockResponseDto;
import com.shopifyexample.inventorymanagement.data.model.IncomingStock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IncomingStockServiceImpl implements IncomingStockService {
    @Autowired
    IncomingStockRepository incomingStockRepository;

    @Override
    public IncomingStockResponseDto addProduct(IncomingStockRequestDto incomingStock) {
        ModelMapper modelMapper = new ModelMapper();
        IncomingStock mappedStock = modelMapper.map(incomingStock, IncomingStock.class);
        IncomingStock stock = incomingStockRepository.save(mappedStock);
        return modelMapper.map(stock, IncomingStockResponseDto.class);
    }

    @Override
    public IncomingStockResponseDto deleteProduct(Long productId) {
        return null;
    }
}
