package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.Repository.InventoryRepository;
import com.shopifyexample.inventorymanagement.data.dto.InventoryRequestDto;
import com.shopifyexample.inventorymanagement.data.dto.InventoryResponseDto;
import com.shopifyexample.inventorymanagement.data.model.Inventory;
import com.shopifyexample.inventorymanagement.exception.InventoryException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public InventoryResponseDto addInventory(InventoryRequestDto incomingStock) {
        if(incomingStock == null){
            throw new NullPointerException("Inventory cannot be null");
        }
        validateInventory(incomingStock);
        ModelMapper modelMapper = new ModelMapper();
        Inventory mappedStock = modelMapper.map(incomingStock, Inventory.class);
        Inventory stock = inventoryRepository.save(mappedStock);
        return modelMapper.map(stock, InventoryResponseDto.class);
    }

    private void validateInventory(InventoryRequestDto incomingStock){
        if(incomingStock.getProductName() == null || incomingStock.getProductName().isBlank()
                || incomingStock.getProductName().isEmpty()){
            throw new InventoryException("Inventory must not have empty product name");
        }

        if(incomingStock.getProductCategory() == null || incomingStock.getProductCategory().isBlank()
                || incomingStock.getProductCategory().isEmpty()){
            throw new InventoryException("Inventory must not have empty product category");
        }
    }

    @Override
    public InventoryResponseDto findById(Long productId) {
        ModelMapper modelMapper = new ModelMapper();
         Optional<Inventory> stockContainer = inventoryRepository.findById(productId);
         if(stockContainer.isPresent()) {
             Inventory stock = stockContainer.get();
             return modelMapper.map(stock, InventoryResponseDto.class);
         }
        throw new IllegalArgumentException("Id does not exist");
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
    public void deleteInventory(Long productId){
        Optional<Inventory> stock = inventoryRepository.findById(productId);
        stock.ifPresent(value -> inventoryRepository.delete(value));
    }

    public void updateInventory(Long id, InventoryRequestDto incomingStock) {
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

    public void writeToCsv() throws IOException {
        File csvFile = new File("inventory.csv");
        if(!csvFile.exists()) {
            boolean newFile = csvFile.createNewFile();
        }

        try (PrintWriter pw = new PrintWriter(csvFile)) {
            inventoryRepository.findAll().stream()
                    .map(Inventory::toCsvRow)
                    .forEach(pw::println);
        }
    }
}
