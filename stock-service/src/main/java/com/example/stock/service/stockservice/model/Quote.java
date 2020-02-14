package com.example.stock.service.stockservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote {

    private String stock;
    private BigDecimal price;
    private String name;
    private BigDecimal change;
    private BigDecimal changePercentage;
}
