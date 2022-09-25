package com.zdotavv.enterprise_homework4.service;

import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Shop;

import java.util.List;

public interface ShopService {
    Shop createShop(Shop shop);

    Long deleteShop(Long shopId) throws NotFoundException;

    Shop getShopById(Long shopId) throws NotFoundException;

    List<Shop> getAllShops();
}
