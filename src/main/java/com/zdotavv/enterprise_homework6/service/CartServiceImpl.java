package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.converters.CartConverter;
import com.zdotavv.enterprise_homework6.converters.PersonConverter;
import com.zdotavv.enterprise_homework6.dto.CartDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework6.model.Cart;
import com.zdotavv.enterprise_homework6.model.Product;
import com.zdotavv.enterprise_homework6.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.zdotavv.enterprise_homework6.converters.ProductConverter.convertProductDtoToProduct;

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
    public CartDto createCartByPersonId(Long idPerson) throws NotFoundException {
        Cart cart = new Cart(PersonConverter.convertPersonDtoToPerson(personService.getPersonById(idPerson)));
        personService.getPersonById(idPerson).getCarts().add(cart);
        return CartConverter.convertCartToCartDto(cartRepository.save(cart));
    }


    @Override
    public CartDto addProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException {
        Cart cart = cartRepository.findById(cartDto.getIdCart()).get();
        Product product = convertProductDtoToProduct(productService.getById(cartDto.getIdProduct()));
        if (cartRepository.findById(cartDto.getIdCart()).isPresent()) {
            cart.getProducts().add(product);
            cart.setSum(cart.getSum().add(BigDecimal.valueOf(productService.getById(cartDto.getIdProduct()).getPrice())));
            cartRepository.save(cart);
            return CartConverter.convertCartToCartDto(cart);
        } else {
            throw new NotFoundException("Cart with ID #" + cartDto.getIdCart() + " is not found");
        }
    }

    @Override
    public CartDto removeProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException {
        Cart cart = cartRepository.findById(cartDto.getIdCart()).get();
        Product product = convertProductDtoToProduct(productService.getById(cartDto.getIdProduct()));
        if (cartRepository.findById(cartDto.getIdCart()).isPresent()) {
            cart.getProducts().remove(product);
            if (cart.getSum().compareTo(new BigDecimal("0.0")) != 0) {
                cart.setSum(cart.getSum().subtract(BigDecimal.valueOf(productService.getById(cartDto.getIdProduct()).getPrice())));
            } else {
                cart.setSum(BigDecimal.valueOf(0.0));
            }
           cartRepository.save(cart);
           return CartConverter.convertCartToCartDto(cart);
        } else {
            throw new NotFoundException("Cart with ID #" + cartDto.getIdCart() + " is not found");
        }
    }

    @Override
    public void removeAllProductsFromCartById(Long idCart)throws NotFoundException {
            if (cartRepository.findById(idCart).isPresent()) {
                Cart cart = cartRepository.findById(idCart).get();
                cart.getProducts().clear();
                cart.setSum(new BigDecimal("0.00"));
                cartRepository.save(cart);
            } else {
                throw new NotFoundException("Cart with ID #" + idCart + " is empty");
            }
    }

    @Override
    public List<CartDto> getAllCarts() {
        List<CartDto> cartDtoList = new ArrayList<>();
        cartRepository.findAll().forEach(cart -> cartDtoList.add(CartConverter.convertCartToCartDto(cart)));
        return cartDtoList;
    }

    @Override
    public CartDto getCartById(Long idCart) {
        if (cartRepository.findById(idCart).isPresent()) {
            return CartConverter.convertCartToCartDto(cartRepository.findById(idCart).get());
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



    }

