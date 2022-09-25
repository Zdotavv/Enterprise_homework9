package com.zdotavv.enterprise_homework4.controller;

import com.zdotavv.enterprise_homework4.dto.ProductDto;
import com.zdotavv.enterprise_homework4.dto.ProductUpdateDto;
import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Product;
import com.zdotavv.enterprise_homework4.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Product createProduct(@RequestBody ProductDto dto)throws NotFoundException{
        return productService.createProduct(dto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@RequestParam Long idProduct) throws NotFoundException {
        return productService.getById(idProduct);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@RequestBody ProductUpdateDto dto) {
        return productService.updateProduct(dto);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long deleteProduct(@RequestParam Long idProduct) throws NotFoundException {
        productService.deleteProduct(idProduct);
        return idProduct;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
}
