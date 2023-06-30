package com.example.beer.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDTO {

    private Long id;
    private Long userID;
    private Date date;
    private double totalPrice;
    private List<ReceiptItem> items;
}
