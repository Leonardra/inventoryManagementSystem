package com.shopifyexample.inventorymanagement.data.Repository;

import com.shopifyexample.inventorymanagement.data.model.IncomingStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IncomingStockRepository extends JpaRepository<IncomingStock, Long> {

}
