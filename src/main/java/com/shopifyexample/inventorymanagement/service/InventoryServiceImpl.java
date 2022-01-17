package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.Repository.InventoryRepository;
import com.shopifyexample.inventorymanagement.data.dto.InventoryRequestDto;
import com.shopifyexample.inventorymanagement.data.dto.InventoryResponseDto;
import com.shopifyexample.inventorymanagement.data.model.Inventory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public InventoryResponseDto addProduct(InventoryRequestDto incomingStock) {
        ModelMapper modelMapper = new ModelMapper();
        Inventory mappedStock = modelMapper.map(incomingStock, Inventory.class);
        Inventory stock = inventoryRepository.save(mappedStock);
        return modelMapper.map(stock, InventoryResponseDto.class);
    }

    @Override
    public InventoryResponseDto findById(Long productId) {
        ModelMapper modelMapper = new ModelMapper();
         Optional<Inventory> stockContainer = inventoryRepository.findById(productId);
         if(stockContainer.isPresent()) {
             Inventory stock = stockContainer.get();
             return modelMapper.map(stock, InventoryResponseDto.class);
         }
        throw new IllegalStateException("Id does not exist");
    }

    @Override
    public List<InventoryResponseDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<Inventory> stocks = inventoryRepository.findAll();
        return stocks.stream()
                .map(e -> modelMapper.map(e, InventoryResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long productId){
        Optional<Inventory> stock = inventoryRepository.findById(productId);
        stock.ifPresent(value -> inventoryRepository.delete(value));
    }

    public void update(Long id, InventoryRequestDto incomingStock) {
        if(incomingStock == null){
            throw new NullPointerException("Inventory item cannot be null");
        }
        ModelMapper modelMapper = new ModelMapper();
        Optional<Inventory> optionalStock = inventoryRepository.findById(id);
        if(optionalStock.isPresent()) {
            Inventory stock = optionalStock.get();
            modelMapper.map(incomingStock, stock);
            inventoryRepository.save(stock);
        }else{
            throw new IllegalArgumentException("Id does not exist for inventory");
        }
    }
}
