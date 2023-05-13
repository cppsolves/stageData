package com.example.ProductService.controller;

import com.example.ProductService.dao.ProductRepository;
import com.example.ProductService.dto.Coupon;
import com.example.ProductService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${couponService.url}")
    private String couponServiceURL;
    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public Product create(@RequestBody Product product)
    {
        Coupon coupon=restTemplate.getForObject(couponServiceURL+product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }
}
