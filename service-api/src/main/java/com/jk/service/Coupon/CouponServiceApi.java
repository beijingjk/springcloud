package com.jk.service.Coupon;

import com.jk.model.Coupon;
import com.jk.model.PetType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CouponServiceApi {

    @RequestMapping(value = "yx/queryCouponList",method = RequestMethod.GET)
    List<Coupon> queryCouponList(@RequestBody Coupon coupon, @RequestParam("start")Integer start, @RequestParam("limit")Integer limit);

    @RequestMapping(value = "yx/queryCouponCount",method = RequestMethod.GET)
    long queryCouponCount(@RequestBody Coupon coupon);
    @RequestMapping(value = "yx/saveCoupon",method = RequestMethod.POST)
    void saveCoupon(@RequestBody Coupon coupon);
    @RequestMapping(value = "yx/delCoupon",method = RequestMethod.GET)
    void delCoupon(@RequestParam("id")String id);
    @RequestMapping(value = "yx/queryAllCouponById",method = RequestMethod.GET)
    Coupon queryAllCouponById(@RequestParam("id")String id);
    @RequestMapping(value = "yx/editCoupon",method = RequestMethod.GET)
    void editCoupon(@RequestBody Coupon coupon);

}
