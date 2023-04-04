package com.example.beer.component;

import com.example.beer.model.Beer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.beer.service.BeerService;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class BeerComponent {
    private final BeerService beerService;
    public BeerComponent(BeerService beerService) {
        this.beerService = beerService;
    }
//    @PostConstruct
//    public void init(){
//        File input = new File("C:\\xampp\\htdocs\\beers.json");
//        try {
//            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//            Beer[] beers = gson.fromJson(new FileReader(input), Beer[].class);
//            beerService.getBeerRepository().saveAll(Arrays.stream(beers).toList());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
