package com.zdotavv.enterprise_homework9.service;

import com.zdotavv.enterprise_homework9.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework9.model.Cart;
import com.zdotavv.enterprise_homework9.model.Product;
import com.zdotavv.enterprise_homework9.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class CartServiceImpl implements CartService{

    private final PersonService personService;
    private final CartRepository cartRepository;
    private final ProductService productService;

    public CartServiceImpl(PersonService personService, CartRepository cartRepository, ProductService productService) {
        this.personService = personService;
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    @Override
    public Cart createCartByPersonId(Long idPerson) throws NotFoundException {
        Cart cart = new Cart(personService.getPersonById(idPerson));
        personService.getPersonById(idPerson).getCarts().add(cart);
         cartRepository.save(cart);
        return cart;
    }


    @Override
    public Cart addProductByProductIdAndCartId(Long idCart, Long idProduct) throws NotFoundException {
        Cart cart = cartRepository.findById(idCart).orElseThrow(() -> new NotFoundException(idCart.toString()));
        Product product = productService.getById(idProduct);
        if (cartRepository.findById(idCart).isPresent()) {
            cart.getProducts().add(product);
            BigDecimal sum = cart.getSum().add(productService.getById(idProduct).getPrice());
            cart.setSum(sum);
            cartRepository.save(cart);
            return cart;
        } else {
            throw new NotFoundException("Cart with ID #" + idCart + " is not found");
        }
    }

    @Override
    public Cart removeProductByProductIdAndCartId(Long idCart, Long idProduct) throws NotFoundException {
        Cart cart = cartRepository.findById(idCart).orElseThrow(() -> new NotFoundException(idCart.toString()));
        Product product = productService.getById(idProduct);
        if (cartRepository.findById(idCart).isPresent()) {
            cart.getProducts().remove(product);
            if (cart.getSum().compareTo(new BigDecimal("0.0")) != 0) {
                BigDecimal sum = cart.getSum().subtract(productService.getById(idProduct).getPrice());
                cart.setSum(sum);
                cartRepository.save(cart);
            } else {
                cart.setSum(BigDecimal.valueOf(0.0));
            }
           cartRepository.save(cart);
           return cart;
        } else {
            throw new NotFoundException("Cart with ID #" + idCart + " is not found");
        }
    }

    @Override
    public void removeAllProductsFromCartById(Long idCart)throws NotFoundException {
            if (cartRepository.findById(idCart).isPresent()) {
                Cart cart = cartRepository.findById(idCart).orElseThrow(() -> new NotFoundException(idCart.toString()));
                cart.getProducts().clear();
                cart.setSum(new BigDecimal("0.00"));
                cartRepository.save(cart);
            } else {
                throw new NotFoundException("Cart with ID #" + idCart + " is empty");
            }
    }

    @Override
    public List<Cart> getAllCarts() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Long idCart) throws NotFoundException {
        if (cartRepository.findById(idCart).isPresent()) {
            return cartRepository.findById(idCart).orElseThrow(() -> new NotFoundException(idCart.toString()));
        } else {
            throw new NotFoundException("Cart with ID #" + idCart + " is not found");
        }
    }

    @Override
    public void removeCartById(Long idCart) throws NotFoundException {
        if (cartRepository.findById(idCart).isPresent()) {
            Cart cart = cartRepository.findById(idCart).orElseThrow(() -> new NotFoundException(idCart.toString()));
            personService.getPersonById(cart.getPerson().getIdPerson()).getCarts().remove(cart);
            cartRepository.deleteById(idCart);
        } else {
            throw new NotFoundException("Cart with ID #" + idCart + "is not found");
        }
    }



    }

