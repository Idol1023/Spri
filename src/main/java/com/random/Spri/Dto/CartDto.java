package com.random.Spri.Dto;


import lombok.Data;

@Data
public class CartDto {
    private Long id;
    private int quantity;

    public CartDto(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
