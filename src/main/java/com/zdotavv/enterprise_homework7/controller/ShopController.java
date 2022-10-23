package com.zdotavv.enterprise_homework7.controller;

import com.zdotavv.enterprise_homework7.dto.ShopDto;
import com.zdotavv.enterprise_homework7.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework7.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.zdotavv.enterprise_homework7.converters.ShopConverter.convertShopDtoToShop;
import static com.zdotavv.enterprise_homework7.converters.ShopConverter.convertShopToShopDto;

@Controller
@RequestMapping(path="/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String shopIndex(Model model) {
        String message = "Shop start page";
        model.addAttribute("message", message);
        return "/shop/shopIndex";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createShopView(Model model) {
        model.addAttribute("shop", new ShopDto());
        return "/shop/createShop";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createShop(@ModelAttribute("shop") ShopDto shopDto) {
        shopService.createShop(convertShopDtoToShop(shopDto));
        return "/shop/createShopSuccess";
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getShopByIdView(Model model) {
        model.addAttribute("shopById", new ShopDto());
        return "/shop/getShop";
    }
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getShopById(@ModelAttribute("shopById") ShopDto shopDto, Model model) throws NotFoundException {
        ShopDto shopById = convertShopToShopDto(shopService.getShopById(shopDto.getIdShop()));
        model.addAttribute("shopById", shopById);
        return "/shop/getShopSuccess";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteShopByIdView(Model model) {
        model.addAttribute("shop", new ShopDto());
        return "/shop/deleteShop";
    }
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteShop(@ModelAttribute("shop") ShopDto shopDto) throws NotFoundException {
        shopService.deleteShop(shopDto.getIdShop());
        return "/shop/deleteShopSuccess";
    }
    @GetMapping( "/all")
    public String getAllShops(Model model) {
        model.addAttribute("all", shopService.getAllShops());
        return "/shop/allShops";
    }
}
