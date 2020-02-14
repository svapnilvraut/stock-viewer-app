package com.example.stock.service.stockservice.api;


import com.example.stock.service.stockservice.model.Quote;
import com.example.stock.service.stockservice.model.UserStock;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class StocksApi {


    private WebClient.Builder stockDbClient;

    public StocksApi(WebClient.Builder stockDbClient) {
        this.stockDbClient = stockDbClient;
    }


    @GetMapping(value="/all", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<UserStock> getAll(){
        return stockDbClient
                .build()
                .get()
                .uri("/all")
                .retrieve()
                .bodyToFlux(UserStock.class);
    }

    @GetMapping(value = "/stock/{username}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Quote> getAllStocks(@PathVariable("username") final String username){

       return stockDbClient
               .build()
                .get()
                .uri("/get/{username}", username)
                .retrieve()
               .bodyToMono(UserStock.class)
               .map(UserStock::getStock)
               .flatMapMany(Flux::fromIterable)
               .map(s -> {
                   System.out.println("Quote: " + s);
                   Stock stock = getStockPrice(s);
                   return new Quote(s,
                           stock.getQuote().getPrice(),
                           stock.getName(),
                           stock.getQuote().getChange(),
                           stock.getQuote().getChangeInPercent()
                   );
               });
    }

    private Stock getStockPrice(String quote){
        try {
            return YahooFinance.get(quote);
        } catch (IOException e) {
            e.printStackTrace();
            return new Stock(quote);
        }
    }

}
