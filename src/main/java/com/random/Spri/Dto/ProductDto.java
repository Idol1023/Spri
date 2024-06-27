package com.random.Spri.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Long price;
    private Integer stockQuantity;



    public ProductDto(){

    }

    public ProductDto(Long id,
                      String name,
                      String description,
                      Long price,
                      Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}


