package com.example.beer.service;

import com.example.beer.model.Beer;
import org.springframework.stereotype.Service;
import com.example.beer.repository.BeerRepository;

@Service
public class BeerService {
    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public BeerRepository getBeerRepository() {
        return beerRepository;
    }

    public Beer addBeer(Beer beer){return beerRepository.save(beer);}
}
