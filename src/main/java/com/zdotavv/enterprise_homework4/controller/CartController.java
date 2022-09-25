package com.zdotavv.enterprise_homework4.controller;

import com.zdotavv.enterprise_homework4.dto.CartDto;
import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Cart;
import com.zdotavv.enterprise_homework4.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Cart createCart(@RequestParam Long idPerson)throws NotFoundException {
        return cartService.createCartByPersonId(idPerson);
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Cart addProductByProductIdAndCartId(@RequestBody CartDto cartDto) throws NotFoundException {
        return cartService.addProductByProductIdAndCartId(cartDto.getIdProduct(), cartDto.getIdCart());
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cart removeProductByProductIdAndCartId(@RequestBody CartDto cartDto) throws NotFoundException {
        return cartService.removeProductByProductIdAndCartId(cartDto.getIdProduct(), cartDto.getIdCart());
    }
    @DeleteMapping("/{idCart}/clean")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllProductsFromCartById(@PathVariable Long idCart)throws NotFoundException {
        cartService.removeAllProductsFromCartById(idCart);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> getAllByPersonId(){
        return cartService.getAllCarts();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Cart getCartById(@RequestParam Long idCart) {
        return cartService.getCartById(idCart);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long removeCartById(@RequestParam Long idCart) throws NotFoundException {
        cartService.removeCartById(idCart);
        return idCart;
    }
}

