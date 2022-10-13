package com.zdotavv.enterprise_homework6.converters;

import com.zdotavv.enterprise_homework6.dto.ProductDto;
import com.zdotavv.enterprise_homework6.model.Product;

public class ProductConverter {
    public static ProductDto convertProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setIdProduct(product.getIdProduct());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setIdShop(product.getShop().getIdShop());
        productDto.setShop(product.getShop());
        return productDto;
    }

    public static Product convertProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setIdProduct(productDto.getIdProduct());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setShop(productDto.getShop());
        product.setShop(productDto.getShop());
        return product;
    }

}
