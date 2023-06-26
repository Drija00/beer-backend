package com.example.beer.repository;

import com.example.beer.model.Receipt;
import com.example.beer.model.ReceiptItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptItemRepository extends JpaRepository<ReceiptItem, Long> {
}
