package com.zdotavv.enterprise_homework9.service;

import com.zdotavv.enterprise_homework9.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework9.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product createProduct(String name, BigDecimal price, Long idShop)throws NotFoundException;;

    Product updateProduct(Long idProduct,String name, BigDecimal price, Long idShop);

   void deleteProduct(Long idProduct) throws NotFoundException;

    Product getById(Long idProduct) throws NotFoundException;

    List<Product> getAllProducts();
}
