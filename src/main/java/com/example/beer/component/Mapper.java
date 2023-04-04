package com.example.beer.component;

import com.example.beer.model.Beer;
import com.example.beer.model.BeerDTO;
import com.example.beer.model.User;
import com.example.beer.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {
    public BeerDTO toDto(Beer b) {
        return new BeerDTO(b.getId(), b.getName(),b.getTagline(),b.getDescription(),b.getImageUrl(),b.getPrice(),b.getFoodPairing());
    }

    public UserDTO toDto(User u) {
        return new UserDTO(u.getId(), u.getFirstname(), u.getLastname(), u.getEmail(), u.getRole(),u.getTokens());
    }

    public Beer toBeer(BeerDTO beerDTO) {
        return new Beer(beerDTO.getName(), beerDTO.getTagline(),beerDTO.getDescription(), beerDTO.getImageUrl(), beerDTO.getPrice(),new ArrayList<>());
    }
}
