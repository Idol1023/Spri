package com.random.Spri.Service;

import com.random.Spri.Dto.CartDto;
import com.random.Spri.Mapper.CartMapper;
import com.random.Spri.Mapper.ProductMapper;
import com.random.Spri.Model.Cart;
import com.random.Spri.Model.Product;
import com.random.Spri.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public CartDto createCart(CartDto cartDto){
        Cart cart = CartMapper.toEntity(cartDto);
        return CartMapper.toDto(cart);
    }


}
