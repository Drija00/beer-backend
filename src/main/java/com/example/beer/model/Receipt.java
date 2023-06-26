package com.example.beer.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="receipt")
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Receipt {

    @Id
    @SequenceGenerator(
            name = "receipt_sequence",
            sequenceName = "receipt_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rececipt_sequence"
    )
    private Long id;
    private Long userID;
    private Date date = new Date();
    private double totalPrice;
    @ElementCollection
    private List<Long> beerIDs;
    @Transient
    private List<ReceiptItem> items;
}
