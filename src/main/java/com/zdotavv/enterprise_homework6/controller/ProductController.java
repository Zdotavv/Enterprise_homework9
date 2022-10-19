package com.zdotavv.enterprise_homework6.controller;

import com.zdotavv.enterprise_homework6.dto.ProductDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework6.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.zdotavv.enterprise_homework6.converters.ProductConverter.convertProductDtoToProduct;
import static com.zdotavv.enterprise_homework6.converters.ProductConverter.convertProductToProductDto;

@Controller
@RequestMapping(path="/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String productIndex(Model model) {
        String message = "Product control page";
        model.addAttribute("message", message);
        return "productIndex";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createProductView(Model model) {
        model.addAttribute("product", new ProductDto());
        return "createProduct";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") ProductDto productDto) throws NotFoundException {
        productService.createProduct(productDto.getName(),productDto.getPrice(),productDto.getIdShop());
        return "createProductSuccess";
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getProductByIdView(Model model) {
        model.addAttribute("productById", new ProductDto());
        return "getProduct";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getProductById(@ModelAttribute("productById") ProductDto productDto, Model model) throws NotFoundException {
        ProductDto productById = convertProductToProductDto(productService.getById(productDto.getIdProduct()));
        model.addAttribute("productById", productById);
        return "getProductSuccess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateProductView(Model model) {
        model.addAttribute("product", new ProductDto());
        return "updateProduct";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("product") ProductDto productDto) {
        productService.updateProduct(productDto.getIdProduct(),productDto.getName(),productDto.getPrice(),productDto.getIdShop());
        return "updateProductSuccess";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProductView(Model model) {
        model.addAttribute("product", new ProductDto());
        return "deleteProduct";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteProduct(@ModelAttribute("product") ProductDto productDto) throws NotFoundException {
        productService.deleteProduct(productDto.getIdProduct());
        return "deleteProductSuccess";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("all", productService.getAllProducts());
        return "allProducts";
    }
}

