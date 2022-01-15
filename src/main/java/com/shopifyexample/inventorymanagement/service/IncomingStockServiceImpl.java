package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.Repository.IncomingStockRepository;
import com.shopifyexample.inventorymanagement.data.dto.IncomingStockRequestDto;
import com.shopifyexample.inventorymanagement.data.dto.IncomingStockResponseDto;
import com.shopifyexample.inventorymanagement.data.model.IncomingStock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public IncomingStockResponseDto findById(Long productId) {
        ModelMapper modelMapper = new ModelMapper();
         Optional<IncomingStock> stockContainer = incomingStockRepository.findById(productId);
         if(stockContainer.isPresent()) {
             IncomingStock stock = stockContainer.get();
             return modelMapper.map(stock, IncomingStockResponseDto.class);
         }
        throw new IllegalStateException("Id does not exist");
    }

    @Override
    public List<IncomingStockResponseDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<IncomingStock> stocks = incomingStockRepository.findAll();
        return stocks.stream()
                .map(e -> modelMapper.map(e, IncomingStockResponseDto.class))
                .collect(Collectors.toList());
    }
}
