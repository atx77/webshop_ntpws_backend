package hr.tvz.diplomski.webshop_ntpws.controller;

import hr.tvz.diplomski.webshop_ntpws.dto.ProductDto;
import hr.tvz.diplomski.webshop_ntpws.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ProductDto getProduct(@PathVariable("productId") Long productId) {
        return productService.getForId(productId);
    }
}
