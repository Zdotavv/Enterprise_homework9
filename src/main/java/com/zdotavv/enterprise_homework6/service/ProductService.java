package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework6.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(String name, Double price, Long idShop)throws NotFoundException;;

    Product updateProduct(Long idProduct,String name, Double price, Long idShop);

   void deleteProduct(Long idProduct) throws NotFoundException;

    Product getById(Long idProduct) throws NotFoundException;

    List<Product> getAllProducts();
}
