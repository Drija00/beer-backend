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
public class ReceiptDTO {

    private Long id;
    private Long userID;
    private Date date;
    private List<Long> beerIDs;
}
