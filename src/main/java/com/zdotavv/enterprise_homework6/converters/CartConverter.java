package com.zdotavv.enterprise_homework6.converters;


import com.zdotavv.enterprise_homework6.dto.CartDto;
import com.zdotavv.enterprise_homework6.model.Cart;

public class CartConverter {

    public static CartDto convertCartToCartDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setIdCart(cart.getIdCart());
        cartDto.setPerson(cart.getPerson());
        cartDto.setProducts(cart.getProducts());
        cartDto.setSum(cart.getSum());
        return cartDto;
    }

    public static Cart convertCartDtoToCart(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setIdCart(cartDto.getIdCart());
        cart.setPerson(cartDto.getPerson());
        cart.setProducts(cartDto.getProducts());
        cart.setSum(cartDto.getSum());
        return cart;
    }
}
