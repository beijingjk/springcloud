package com.jk.service.Coupon;

import com.jk.model.*;
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
    @RequestMapping(value = "yx/queryOrderList",method = RequestMethod.GET)
    List<Order> queryOrderList(@RequestBody Order order, @RequestParam("start")Integer start, @RequestParam("limit")Integer limit);
    @RequestMapping(value = "yx/queryOrderCount",method = RequestMethod.GET)
    long queryOrderCount(@RequestBody Order order);
    @RequestMapping(value = "yx/queryAllOrderById",method = RequestMethod.GET)
    Order queryAllOrderById(@RequestParam("orderId")String orderId);
    @RequestMapping(value = "yx/editOrder",method = RequestMethod.GET)
    void editOrder(@RequestBody Order order);
    @RequestMapping(value = "yx/getOrdersShow",method = RequestMethod.GET)
    List<OrderItem> getOrdersShow();
    @RequestMapping(value = "yx/getOrdersShow1",method = RequestMethod.GET)
    List<Order> getOrdersShow1();
    @RequestMapping(value = "yx/getOrdersShow2",method = RequestMethod.GET)
    List<OrderShipping> getOrdersShow2();
    @RequestMapping(value = "yx/queryTuikUAn",method = RequestMethod.GET)
    Order queryTuikUAn(@RequestParam("orderId")String orderId);
    @RequestMapping(value = "yx/editOrder666",method = RequestMethod.GET)
    void editOrder666(@RequestBody Order order);
}
