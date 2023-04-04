package com.example.beer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class BeerDTO {

        private Long id;
        private String name;
        private String tagline;
        private String description;
        private String imageUrl;
        private double price;
        private List<String> foodPairing;
        public BeerDTO(Long id, String name, String tagline, String description, String imageUrl, double price, List<String> foodPairing) {
            this.id = id;
            this.name = name;
            this.tagline = tagline;
            this.description = description;
            this.imageUrl = imageUrl;
            this.price = price;
            this.foodPairing = foodPairing;
        }
}
