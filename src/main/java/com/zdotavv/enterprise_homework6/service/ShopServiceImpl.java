package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.converters.ShopConverter;
import com.zdotavv.enterprise_homework6.repository.ShopRepository;
import com.zdotavv.enterprise_homework6.dto.ShopDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public ShopDto createShop(ShopDto shopDto) {
        return ShopConverter.convertShopToShopDto(shopRepository.save(ShopConverter.convertShopDtoToShop(shopDto)));

    }

    @Override
    public void deleteShop(Long idShop) throws NotFoundException {
        if (shopRepository.existsById(idShop)) {
            shopRepository.deleteById(idShop);
        } else {
            throw new NotFoundException("Shop with ID #" + idShop + " is not found");
        }
    }

    @Override
    public ShopDto getShopById(Long idShop) throws NotFoundException {
        if (shopRepository.findById(idShop).isPresent()) {
            return ShopConverter.convertShopToShopDto(shopRepository.findById(idShop).get());
        } else {
            throw new NotFoundException("Shop with ID #" + idShop + " is not found");
        }
    }

    @Override
    public List<ShopDto> getAllShops() {
        List<ShopDto> ListShopDto = new ArrayList<>();
        shopRepository.findAll().forEach(shop -> ListShopDto.add(ShopConverter.convertShopToShopDto(shop)));
        return ListShopDto;
    }
}
