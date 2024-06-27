package com.random.Spri.Controller;

import com.random.Spri.Dto.CartDto;
import com.random.Spri.Dto.ProductDto;
import com.random.Spri.Repository.CartRepository;
import com.random.Spri.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("v1/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    public ResponseEntity<CartDto> createProduct(@RequestBody CartDto cartDto) {
        CartDto createdCart = cartService.createCart(cartDto);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }
}
