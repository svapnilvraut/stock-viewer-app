package com.example.stock.stockdbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StockDbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockDbServiceApplication.class, args);
	}

}
