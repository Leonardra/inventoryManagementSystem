package com.shopifyexample.inventorymanagement.web.controller;

import com.shopifyexample.inventorymanagement.data.dto.InventoryRequestDto;
import com.shopifyexample.inventorymanagement.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryServiceImpl;


    @PostMapping("")
    public ResponseEntity<?> addInventory(@RequestBody InventoryRequestDto inventory){
        return new ResponseEntity<>(inventoryServiceImpl.addInventory(inventory), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllInventory(){
        return new ResponseEntity<>(inventoryServiceImpl.findAll(), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long id){
        inventoryServiceImpl.deleteInventory(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateInventory(@PathVariable Long id, @RequestBody InventoryRequestDto inventoryDto){
        inventoryServiceImpl.updateInventory(id, inventoryDto);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/downloadCsv")
    public ResponseEntity<?> writeToFile(){
        try {
            inventoryServiceImpl.writeToCsv();
            return ResponseEntity.ok().body("File download was successful, check inventory.csv in the program directory");
        }catch (IOException ex){
            return ResponseEntity.badRequest().body("Error processing request");
        }
    }
}
