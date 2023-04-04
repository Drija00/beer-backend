package com.example.beer.controller;

import com.example.beer.component.Mapper;
import com.example.beer.model.Beer;
import com.example.beer.model.BeerDTO;
import com.example.beer.service.BeerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
public class BeerController {
    private final BeerService service;
    private final Mapper mapper;

    public BeerController(BeerService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/beers")
    @ResponseBody
    public List<BeerDTO> getBeers() {
        return service.getBeerRepository().findAll()
                .stream()
                .map(mapper::toDto)
                .collect(toList());
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/beers/{id}")
    @ResponseBody
    public Beer one(@PathVariable Long id) {
        Optional<Beer> beer = service.getBeerRepository().findById(id);
        if (beer.isPresent()){
            return beer.get();
        }
        return null;
    }



}
