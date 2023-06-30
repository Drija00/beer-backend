package com.example.beer.controller;

import com.example.beer.component.Mapper;
import com.example.beer.model.Receipt;
import com.example.beer.model.ReceiptDTO;
import com.example.beer.model.ReceiptItem;
import com.example.beer.model.ReceiptItemDTO;
import com.example.beer.service.ReceiptItemService;
import com.example.beer.service.ReceiptService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ReceiptController {
    private final ReceiptService receiptService;
    private final ReceiptItemService receiptItemService;

    private final Mapper mapper;

    public ReceiptController(ReceiptService receiptService, ReceiptItemService receiptItemService, Mapper mapper) {
        this.receiptService = receiptService;
        this.receiptItemService = receiptItemService;
        this.mapper = mapper;
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping("/add-receipt")
//    public Receipt addReceipt(@RequestParam Long userID,
//                              @RequestParam double totalPrice,
//                              @RequestParam List<ReceiptItemDTO> items){
//        Receipt receipt = new Receipt();
//        receipt.setUserID(userID);
//        receipt.setTotalPrice(totalPrice);
//        receipt.setDate(new Date());
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+items);
//        //receipt.setBeerIDs(beerIDs);
//        //System.out.println(items);
////        for(ReceiptItem item:items){
////            item.setReceiptID(receipt1.getId());
////            item.toString();
////        }
//        return receiptService.addReceipt(receipt);
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add-receipt")
    public Receipt addReceipt(@RequestBody Receipt receipt){
        Receipt receiptFinal = receiptService.addReceipt(receipt);
        for(ReceiptItem item:receipt.getItems()){
            item.setReceiptID(receiptFinal.getId());
            receiptItemService.addReceiptItem(item);
        }
        return receiptFinal;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add-receiptitem")
    public ReceiptItem addReceiptItem(@RequestParam Long receiptID,
                                      @RequestParam Long beerID,
                                      @RequestParam int quantity){
        ReceiptItem receiptItem = new ReceiptItem();
        return receiptItemService.addReceiptItem(receiptItem);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/receipts")
    public List<Receipt> getReceipts(){
        List<Receipt> receipts= receiptService.getReceipts();
        for (Receipt receipt : receipts){
            receipt.setItems(receiptItemService.getReceiptItemsByReceiptID(receipt.getId()));
        }
        return receipts;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/receiptitems")
    public List<ReceiptItem> getReceiptItems(Long receiptID){
        return receiptItemService.getReceiptItems();
    }
}
