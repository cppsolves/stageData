package com.geekster.Doctor.controller;

import com.geekster.Doctor.dao.CouponRepository;
import com.geekster.Doctor.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponsRestController {
    @Autowired
    CouponRepository couponRepository;
    @RequestMapping(value = "/coupons",method = RequestMethod.POST)
    public Coupon create(@RequestBody Coupon coupon)
    {
        return couponRepository.save(coupon);
    }
    @RequestMapping(value = "/coupons/{code}",method = RequestMethod.GET)
    public Coupon getCoupon(@PathVariable("code") String code)
    {
        return couponRepository.findByCode(code);
    }
}
