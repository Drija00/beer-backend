package com.example.beer.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="receiptitem")
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ReceiptItem {

    @Id
    @SequenceGenerator(
            name = "receipt_item_sequence",
            sequenceName = "receipt_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rececipt_item_sequence"
    )
    private Long id;
    private Long receiptID;
    private Long beerID;
    private int quantity;
}
