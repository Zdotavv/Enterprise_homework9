package com.zdotavv.enterprise_homework4.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDto {

    private Long idProduct;

    private String name;

    private Double price;

    private Long idShop;
}
