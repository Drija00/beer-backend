package com.example.beer.component;

import com.example.beer.service.ReceiptService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ReceiptComponent {
    private final ReceiptService receiptService;

    public ReceiptComponent(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }
    @PostConstruct
    public void init(){

    }
}
