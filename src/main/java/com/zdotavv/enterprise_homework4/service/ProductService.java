package com.zdotavv.enterprise_homework4.service;

import com.zdotavv.enterprise_homework4.dto.ProductDto;
import com.zdotavv.enterprise_homework4.dto.ProductUpdateDto;
import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDto dto)throws NotFoundException;;

    Product updateProduct(ProductUpdateDto dto);

   Long deleteProduct(Long idProduct) throws NotFoundException;

    Product getById(Long id) throws NotFoundException;

    List<Product> getAllProducts();
}
