package com.zdotavv.enterprise_homework4.service;

import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Cart;

import java.util.List;

public interface CartService {
    Cart createCartByPersonId(Long idPerson) throws NotFoundException;

    Cart addProductByProductIdAndCartId(Long idProduct,Long idCart) throws NotFoundException;

    Cart removeProductByProductIdAndCartId(Long idProduct,Long idCart) throws NotFoundException;

    Long removeAllProductsFromCartById(Long idCart)throws NotFoundException ;

    List<Cart> getAllCarts();

    Cart getCartById(Long id);

    Long removeCartById(Long idCart) throws NotFoundException;
}
