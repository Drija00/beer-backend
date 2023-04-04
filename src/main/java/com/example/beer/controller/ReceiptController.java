package com.example.beer.controller;

import com.example.beer.model.Receipt;
import com.example.beer.service.ReceiptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceiptController {
    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add-receipt")
    public Receipt addReceipt(@RequestBody Receipt receipt){
        return receiptService.addReceipt(receipt);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/receipts")
    public List<Receipt> getReceipts(){
        return receiptService.getReceipts();
    }
}
