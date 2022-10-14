package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.dto.ProductDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework6.model.Product;
import com.zdotavv.enterprise_homework6.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.zdotavv.enterprise_homework6.converters.ProductConverter.convertProductDtoToProduct;
import static com.zdotavv.enterprise_homework6.converters.ProductConverter.convertProductToProductDto;
import static com.zdotavv.enterprise_homework6.converters.ShopConverter.convertShopDtoToShop;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ShopService shopService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ShopService shopService) {
        this.productRepository = productRepository;
        this.shopService = shopService;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) throws NotFoundException {
        Product product = new Product(productDto.getName(),productDto.getPrice());
        product.setShop(convertShopDtoToShop(shopService.getShopById(productDto.getIdShop())));
        shopService.getShopById(productDto.getIdShop()).getProducts().add(product);
        productRepository.save(product);
        return convertProductToProductDto(product);
    }


    @Override
    public ProductDto updateProduct(ProductDto productDto){
        return productRepository.findById(productDto.getIdProduct())
                .map(entity -> {
                    entity.setName(productDto.getName());
                    entity.setPrice(productDto.getPrice());
                    try {
                        entity.setShop(convertShopDtoToShop(shopService.getShopById(productDto.getIdShop())));
                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    return convertProductToProductDto(productRepository.save(entity));
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + productDto.getIdProduct()));
    }

    @Override
    public void deleteProduct(Long idProduct) throws NotFoundException {
        if (productRepository.existsById(idProduct)) {
            shopService.getShopById((productRepository.findById(idProduct).get()).getShop().getIdShop()).getProducts().remove(convertProductDtoToProduct(getById(idProduct)));
            productRepository.deleteById(idProduct);
        } else {
            throw new NotFoundException("Product with ID #" + idProduct + " is not found");
        }
    }

    @Override
    public ProductDto getById(Long idProduct) throws NotFoundException  {
        if (productRepository.findById(idProduct).isPresent()) {
            return convertProductToProductDto(productRepository.findById(idProduct).get());
        } else {
            throw new NotFoundException("Product with ID #" + idProduct + " is not found");
        }
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepository.findAll().forEach(product -> productDtoList.add(convertProductToProductDto(product)));
        return productDtoList;
    }

}
