package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.dto.ShopDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;

import java.util.List;

public interface ShopService {
    ShopDto createShop(ShopDto shopDto);

    void deleteShop(Long idShop) throws NotFoundException;

    ShopDto getShopById(Long idShop) throws NotFoundException;

    List<ShopDto> getAllShops();
}
