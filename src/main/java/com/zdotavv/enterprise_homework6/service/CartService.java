package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.dto.CartDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;

import java.util.List;

public interface CartService {
    CartDto createCartByPersonId(Long idPerson) throws NotFoundException;

    CartDto addProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException;

    CartDto removeProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException;

    void removeAllProductsFromCartById(Long idCart)throws NotFoundException ;

    List<CartDto> getAllCarts();

    CartDto getCartById(Long idCart);

    Long removeCartById(Long idCart) throws NotFoundException;
}
