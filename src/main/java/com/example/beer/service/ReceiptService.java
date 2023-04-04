package com.example.beer.service;

import com.example.beer.model.Receipt;
import com.example.beer.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {
    private final ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public Receipt addReceipt(Receipt receipt){
        System.out.println(receipt);
        return receiptRepository.save(receipt);
    }

    public List<Receipt> getReceipts(){
        return receiptRepository.findAll();
    }
}
