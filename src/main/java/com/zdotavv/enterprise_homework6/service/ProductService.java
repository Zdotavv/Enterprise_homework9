package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.dto.ProductDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto)throws NotFoundException;;

    ProductDto updateProduct(ProductDto productDto);

   void deleteProduct(Long idProduct) throws NotFoundException;

    ProductDto getById(Long idProduct) throws NotFoundException;

    List<ProductDto> getAllProducts();
}
