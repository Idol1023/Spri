package com.random.Spri.Mapper;

import com.random.Spri.Dto.CartDto;
import com.random.Spri.Dto.ProductDto;
import com.random.Spri.Model.Cart;
import com.random.Spri.Model.Product;

public class CartMapper {
    public static CartDto toDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getQuantity()
        );
    }

    public static Cart toEntity(CartDto cartDto) {
        Cart cart= new Cart();
        cart.setId(cartDto.getId());
        cart.setQuantity(cartDto.getQuantity());
        return cart;
    }
}
