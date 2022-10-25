package com.zdotavv.enterprise_homework9.service;

import com.zdotavv.enterprise_homework9.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework9.model.Shop;

import java.util.List;


public interface ShopService {
    Shop createShop(Shop shop);

    void deleteShop(Long idShop) throws NotFoundException;

    Shop getShopById(Long idShop) throws NotFoundException;

    List<Shop> getAllShops();
}
