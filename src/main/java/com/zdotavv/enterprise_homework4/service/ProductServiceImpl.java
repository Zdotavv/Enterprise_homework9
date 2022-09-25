package com.zdotavv.enterprise_homework4.service;

import com.zdotavv.enterprise_homework4.dto.ProductDto;
import com.zdotavv.enterprise_homework4.dto.ProductUpdateDto;
import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Product;
import com.zdotavv.enterprise_homework4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
    public Product createProduct(ProductDto dto) throws NotFoundException {
        Product product = new Product(dto.getName(), dto.getPrice());
        product.setShop(shopService.getShopById(dto.getShopId()));
        shopService.getShopById(dto.getShopId()).getProducts().add(product);
        return productRepository.save(product);
    }


    @Override
    public Product updateProduct(ProductUpdateDto dto){
        return productRepository.findById(dto.getIdProduct())
                .map(entity -> {
                    entity.setName(dto.getName());
                    entity.setPrice(dto.getPrice());
                    try {
                        entity.setShop(shopService.getShopById(dto.getIdShop()));
                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    return productRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + dto.getIdProduct()));
    }

    @Override
    public Long deleteProduct(Long idProduct) throws NotFoundException {
        if (productRepository.existsById(idProduct)) {
            shopService.getShopById((productRepository.findById(idProduct).get()).getShop().getIdShop()).getProducts().remove(getById(idProduct));
            productRepository.deleteById(idProduct);
            return idProduct;
        } else {
            throw new NotFoundException("Product with ID #" + idProduct + " is not found");
        }
    }

    @Override
    public  Product getById(Long idProduct) throws NotFoundException  {
        if (productRepository.findById(idProduct).isPresent()) {
            return productRepository.findById(idProduct).get();
        } else {
            throw new NotFoundException("Product with ID #" + idProduct + " is not found");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

}
