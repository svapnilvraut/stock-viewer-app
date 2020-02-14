package com.example.stock.stockdbservice.repository;

import com.example.stock.stockdbservice.model.Stock;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface StocksRepository extends ReactiveMongoRepository<Stock, String>{
    Mono<Stock> findByUsername(String userName);
}