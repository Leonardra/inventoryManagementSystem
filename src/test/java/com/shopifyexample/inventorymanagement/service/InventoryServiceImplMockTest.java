//package com.shopifyexample.inventorymanagement.service;
//
//import com.shopifyexample.inventorymanagement.data.Repository.InventoryRepository;
//import com.shopifyexample.inventorymanagement.data.dto.InventoryRequestDto;
//import com.shopifyexample.inventorymanagement.data.dto.InventoryResponseDto;
//import com.shopifyexample.inventorymanagement.data.model.Inventory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//
//@ExtendWith(MockitoExtension.class)
//class InventoryServiceImplMockTest {
//
//    @InjectMocks
//    InventoryServiceImpl inventoryService;
//    @Mock
//    InventoryRepository inventoryRepository;
//
//    private ModelMapper modelMapper;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        modelMapper = new ModelMapper();
//    }
//
//    @Test
//    void addProduct() {
//        InventoryRequestDto incomingStock = new InventoryRequestDto(
//                "Hp EliteBook",
//                "Hp",
//                "Electronic",
//                12000.00,
//                10
//        );
//        Inventory stock = modelMapper.map(incomingStock, Inventory.class);
//        when(inventoryRepository.save(stock)).thenReturn(stock);
//        InventoryResponseDto responseStock = inventoryService.addInventory(incomingStock);
//        assertThat(responseStock).isNotNull();
//        verify(inventoryRepository, times(1)).save(stock);
//    }
//
//    @Test
//    void findStockById(){
//        InventoryRequestDto incomingStock = new InventoryRequestDto(
//                "Hp EliteBook",
//                "Hp",
//                "Electronic",
//                12000.00,
//                10
//        );
//
//        Inventory stock = modelMapper.map(incomingStock, Inventory.class);
//        when(inventoryRepository.save(stock)).thenReturn(stock);
//        inventoryService.addInventory(incomingStock);
//        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(stock));
//        inventoryService.findById(1L);
//        verify(inventoryRepository, times(1)).findById(any());
//        verify(inventoryRepository, times(1)).save(stock);
//    }
//
//    @Test
//    void deleteStock(){
//        InventoryRequestDto incomingStock = new InventoryRequestDto(
//                "Hp EliteBook",
//                "Hp",
//                "Electronic",
//                12000.00,
//                10
//        );
//
//        Inventory stock = modelMapper.map(incomingStock, Inventory.class);
//        when(inventoryRepository.save(stock)).thenReturn(stock);
//        inventoryService.addInventory(incomingStock);
//        when(inventoryRepository.findById(any())).thenReturn(Optional.of(stock)).thenReturn(null);
//        inventoryService.deleteInventory(1L);
//        assertThat(inventoryRepository.findAll().size()).isEqualTo(0);
//        verify(inventoryRepository,times(1)).delete(any());
//    }
//
//}