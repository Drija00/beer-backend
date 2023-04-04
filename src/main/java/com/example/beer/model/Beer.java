package com.example.beer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="beer")
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Beer {
    @Id
    @SequenceGenerator(
            name = "beer_sequence",
            sequenceName = "beer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "beer_sequence"
    )
    @Column
    @Expose(serialize = true)
    private Long id;

    @Column
    @Expose(serialize = true)
    private String name;

    @Column
    @Expose(serialize = true)
    private String tagline;

    @Column(length = 1000)
    @Expose(serialize = true)
    private String description;

    @Column
    @Expose(serialize = true)
    @SerializedName("image_url")
    private String imageUrl;

    @Column
    @Expose(serialize = true)
    @SerializedName("abv")
    private double price;
    @ElementCollection
    @Expose(serialize = true)
    @SerializedName("food_pairing")
    private List<String> foodPairing;

    public Beer(String name, String tagline, String description, String imageUrl, double price, List<String> foodPairing) {
        this.name = name;
        this.tagline = tagline;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.foodPairing = foodPairing;
    }

    public Beer(Long id, String name, String tagline, String description, String imageUrl, double price, List<String> foodPairing) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.foodPairing = foodPairing;
    }
}
