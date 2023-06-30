package com.example.beer.component;

import com.example.beer.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Mapper {
    public BeerDTO toDto(Beer b) {
        return new BeerDTO(b.getId(), b.getName(),b.getTagline(),b.getDescription(),b.getImageUrl(),b.getPrice(),b.getFoodPairing());
    }

    public ReceiptDTO toDto(Receipt r) {
        return new ReceiptDTO(r.getId(),r.getUserID(),r.getDate(),r.getTotalPrice(),r.getItems());
    }


    public UserDTO toDto(User u) {
        return new UserDTO(u.getId(), u.getFirstname(), u.getLastname(), u.getEmail(), u.getRole(),u.getTokens());
    }

    public Beer toBeer(BeerDTO beerDTO) {
        return new Beer(beerDTO.getName(), beerDTO.getTagline(),beerDTO.getDescription(), beerDTO.getImageUrl(), beerDTO.getPrice(),new ArrayList<>());
    }
}
