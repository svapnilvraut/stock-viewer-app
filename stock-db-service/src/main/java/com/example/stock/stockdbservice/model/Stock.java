package com.example.stock.stockdbservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock{

    @Id
    private String id;
    private String username;
    private List<String> stock;
}