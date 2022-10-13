package com.zdotavv.enterprise_homework6.dto;

import com.zdotavv.enterprise_homework6.model.Shop;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long idProduct;

    private String name;

    private Double price;

    private Shop shop;

    private Long IdShop;
}
