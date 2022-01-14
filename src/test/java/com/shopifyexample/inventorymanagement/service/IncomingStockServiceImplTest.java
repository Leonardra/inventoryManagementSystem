package com.shopifyexample.inventorymanagement.service;

import com.shopifyexample.inventorymanagement.data.Repository.IncomingStockRepository;
import com.shopifyexample.inventorymanagement.data.dto.IncomingStockRequestDto;
import com.shopifyexample.inventorymanagement.data.model.IncomingStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class IncomingStockServiceImplTest {

    @InjectMocks
    IncomingStockServiceImpl incomingStockService;
    @Mock
    IncomingStockRepository incomingStockRepository;

    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = new ModelMapper();
    }

    @Test
    void addProduct() {
        IncomingStockRequestDto incomingStock = new IncomingStockRequestDto(
                "Hp EliteBook",
                "Hp",
                "Electronic",
                12000.00,
                10
        );
        IncomingStock stock = modelMapper.map(incomingStock, IncomingStock.class);
        when(incomingStockRepository.save(stock)).thenReturn(stock);
        incomingStockService.addProduct(incomingStock);
        verify(incomingStockRepository, times(1)).save(stock);
    }


}