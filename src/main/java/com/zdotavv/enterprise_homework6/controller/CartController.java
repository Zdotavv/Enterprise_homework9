package com.zdotavv.enterprise_homework6.controller;

import com.zdotavv.enterprise_homework6.service.CartService;
import com.zdotavv.enterprise_homework6.dto.CartDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public String cartIndex(Model model) {
//        String message = "Cart control page";
//        model.addAttribute("message", message);
//        return "cartIndex";
//    }

//    @RequestMapping(value="/create",method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public String createCartView(Model model){
//     model.addAttribute("person", new PersonDto());
//        model.addAttribute("cart", new CartDto());
//        return "createCart";
//    }
 @PostMapping("/create")
 @ResponseStatus(HttpStatus.OK)
    public CartDto createCart(@ModelAttribute("person") Long idCart) throws NotFoundException {
        return cartService.createCartByPersonId(idCart);
    }
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public String addProductView(Model model) {
//        model.addAttribute("product", new ProductDto());
//        return "addProductToCart";
//    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public CartDto addProduct(@ModelAttribute("product") CartDto cartDto) throws NotFoundException {
        return cartService.addProductByProductIdAndCartId(cartDto);
    }
//    @RequestMapping(value = "/remove", method = RequestMethod.GET)
//    public String removeProductByProductIdView(Model model) {
//        model.addAttribute("product", new ProductDto());
//        return "removeProductFromCart";
//    }
@DeleteMapping("/delete")
@ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public CartDto removeProductByProductId(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        return cartService.removeProductByProductIdAndCartId(cartDto);
    }
    @DeleteMapping("/{cartId}/clean")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllProductsFromCartById(@PathVariable Long cartId) throws NotFoundException {
        cartService.removeAllProductsFromCartById(cartId);
    }
//    @GetMapping("/all")
//    public String getAllCarts(Model model) {
//        model.addAttribute("all", cartService.getAllCarts());
//        return "allCarts";
//    }
@GetMapping("/all")
@ResponseStatus(HttpStatus.OK)
        public List<CartDto> getAllCarts(){
            return cartService.getAllCarts();
    }
//    @GetMapping("/all")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Cart> getAllByPersonId(){
//        return cartService.getAllCarts();
//    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public CartDto getCartById(@RequestParam Long idCart) {
        return cartService.getCartById(idCart);
    }

//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public Cart getCartById(@RequestParam Long idCart) {
//        return cartService.getCartById(idCart);
//    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCartById(@ModelAttribute("cart") Long cartId) throws NotFoundException {
        cartService.removeCartById(cartId);
    }
}

