package com.example.beer.service;

import com.example.beer.model.ReceiptItem;
import com.example.beer.repository.ReceiptItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptItemService {

    private final ReceiptItemRepository receiptItemRepository;


    public ReceiptItemService(ReceiptItemRepository receiptItemRepository) {
        this.receiptItemRepository = receiptItemRepository;
    }

    public ReceiptItem addReceiptItem(ReceiptItem receiptItem){
        System.out.println(receiptItem);
        return receiptItemRepository.save(receiptItem);
    }

    public List<ReceiptItem> getReceiptItems(){
        return receiptItemRepository.findAll();
    }

    public List<ReceiptItem> getReceiptItemsByReceiptID(Long id){
        return receiptItemRepository.findAllByReceiptID(id);
    }
}
