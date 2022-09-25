package com.zdotavv.enterprise_homework4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String name;

    private Double price;
    @ManyToOne
    private Shop shop;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
