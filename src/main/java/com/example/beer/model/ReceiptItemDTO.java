package com.example.beer.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptItemDTO {
    private Long beerID;
    private int quantity;
}

