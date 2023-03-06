package com.example.pocjava.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Product {
    private Integer id;
    private String productName;
}
