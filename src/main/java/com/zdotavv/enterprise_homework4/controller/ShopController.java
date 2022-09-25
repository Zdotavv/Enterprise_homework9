package com.zdotavv.enterprise_homework4.controller;

import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Shop;
import com.zdotavv.enterprise_homework4.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Shop createShop(@RequestBody Shop shop){
        return shopService.createShop(shop);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Shop getShopById(@RequestParam Long shopId) throws NotFoundException {
        return shopService.getShopById(shopId);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long deleteShop(@RequestParam Long idShop) throws NotFoundException {
        shopService.deleteShop(idShop);
        return idShop;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Shop> getAll() {
        return shopService.getAllShops();
    }

}
