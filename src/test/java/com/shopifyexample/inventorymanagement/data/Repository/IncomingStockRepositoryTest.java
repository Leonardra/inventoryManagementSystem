package com.shopifyexample.inventorymanagement.data.Repository;

import com.shopifyexample.inventorymanagement.data.model.IncomingStock;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AssertProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Slf4j
//@Sql(scripts={"/db/insert.sql"})
class IncomingStockRepositoryTest {

    @Autowired
    IncomingStockRepository incomingStockRepositoryImpl;


    @Test
    void createIncomingStock(){
        IncomingStock incomingStock = new IncomingStock();
        incomingStock.setProductName("Hp Pavilion");
        incomingStock.setBrand("HP");
        incomingStock.setProductCategory("Electronics");
        incomingStock.setPrice(70000.00);
        incomingStock.setQuantity(20);

        assertThat(incomingStock.getId()).isNull();
        log.info("incomingStock before saving -> {}", incomingStock);
        incomingStockRepositoryImpl.save(incomingStock);
        assertThat(incomingStock.getId()).isNotNull();
        log.info("incomingStock after saving -> {}", incomingStock);
    }

    @Test
    void testThatIncomingStockCanBeFoundById(){
        IncomingStock stock = incomingStockRepositoryImpl.findById(2L).orElse(null);
        assertThat(stock).isNotNull();
        log.info("Found incoming stock -> {}", stock);
    }

    @Test
    void testThatAllIncomingStockCanBeFound(){
        List<IncomingStock> stocks = incomingStockRepositoryImpl.findAll();
        assertThat(stocks).isNotNull();
        log.info("Found incoming stock -> {}", stocks);
    }

}