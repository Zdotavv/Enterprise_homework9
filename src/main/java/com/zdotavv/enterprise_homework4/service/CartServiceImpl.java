package com.zdotavv.enterprise_homework4.service;

import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Cart;
import com.zdotavv.enterprise_homework4.model.Product;
import com.zdotavv.enterprise_homework4.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
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
        return cartRepository.save(cart);
    }


    @Override
    public Cart addProductByProductIdAndCartId(Long idProduct,Long idCart) throws NotFoundException {
        Cart cart = cartRepository.findById(idCart).get();
        Product product = productService.getById(idProduct);
        if (cartRepository.findById(idCart).isPresent()) {
            cart.getProducts().add(product);
            cart.setSum(cart.getSum().add(BigDecimal.valueOf(productService.getById(idProduct).getPrice())));
            cartRepository.save(cart);
            return cart;
        } else {
            throw new NotFoundException("Cart with ID #" + idCart + " is not found");
        }
    }

    @Override
    public Cart removeProductByProductIdAndCartId(Long idProduct,Long idCart) throws NotFoundException {
        Cart cart = cartRepository.findById(idCart).get();
        Product product = productService.getById(idProduct);
        checkNotContainsProduct(cart, product);
        if (cartRepository.findById(idCart).isPresent()) {
            cart.getProducts().remove(product);
            if (cart.getSum().compareTo(new BigDecimal("0.0")) != 0) {
                cart.setSum(cart.getSum().subtract(BigDecimal.valueOf(productService.getById(idProduct).getPrice())));
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
    public Long removeAllProductsFromCartById(Long idCart)throws NotFoundException {
            if (cartRepository.findById(idCart).isPresent()) {
                Cart cart = cartRepository.findById(idCart).get();
                cart.getProducts().clear();
                cart.setSum(new BigDecimal("0.00"));
                cartRepository.save(cart);
                return idCart;
            } else {
                throw new NotFoundException("Cart with ID #" + idCart + " is empty");
            }
    }

    @Override
    public List<Cart> getAllCarts() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Long idCart) {
        if (cartRepository.findById(idCart).isPresent()) {
            return cartRepository.findById(idCart).get();
        }
        try {
            throw new NotFoundException("Cart with ID #" + idCart + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Long removeCartById(Long idCart) throws NotFoundException {
        if (cartRepository.findById(idCart).isPresent()) {
            Cart cart = cartRepository.findById(idCart).get();
            personService.getPersonById(cart.getPerson().getIdPerson()).getCarts().remove(cart);
            cartRepository.deleteById(idCart);
            return idCart;
        }
        try {
            throw new NotFoundException("Cart with ID #" + idCart + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void checkNotContainsProduct(Cart cart, Product product) {
        if (!cart.getProducts().contains(product)) {
            try {
                throw new NotFoundException("Cart don't contains product with ID #" + product.getIdProduct());
            } catch (NotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    }

