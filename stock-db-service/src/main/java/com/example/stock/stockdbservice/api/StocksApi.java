package com.example.stock.stockdbservice.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import com.example.stock.stockdbservice.model.Stock;
import com.example.stock.stockdbservice.repository.StocksRepository;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/v1")
public class StocksApi {

    private StocksRepository stockRepo;

    public StocksApi(StocksRepository stockRepo){
        this.stockRepo = stockRepo;
    }

    @GetMapping(value="/get/{username}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Stock> getStocksForUser(@PathVariable("username") final String userName) {
        return stockRepo.findByUsername(userName);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Stock> getAllStocks(){
        return stockRepo.findAll();
    }

}
