package com.zdotavv.enterprise_homework9.dto;


import com.zdotavv.enterprise_homework9.model.Person;
import com.zdotavv.enterprise_homework9.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CartDto {
    private Long IdCart;
    private Person person;
    private List<Product> products;
    private BigDecimal sum;
    private Long idProduct;
}
