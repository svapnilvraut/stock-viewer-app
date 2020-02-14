package com.example.stock.service.stockservice.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class StockDbServiceClient {

    @LoadBalanced
    @Bean
    WebClient.Builder stockDbClient(){
        return WebClient.builder().baseUrl("http://stock-db-service/v1");
    }
}
