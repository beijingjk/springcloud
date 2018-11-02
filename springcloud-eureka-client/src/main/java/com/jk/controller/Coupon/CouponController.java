package com.jk.controller.Coupon;


import com.jk.model.*;
import com.jk.service.Coupon.CouponServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("yx")
public class CouponController {

      @Autowired
      private CouponServiceApi couponService;

      //优惠券分页列表
      @RequestMapping("queryCouponList")
      @ResponseBody
      public List<Coupon> queryCouponList(@RequestBody Coupon coupon, @RequestParam Integer start, @RequestParam Integer limit) {
            List<Coupon> list = couponService.queryCouponList(coupon,start,limit);
            return list;
      }
      @RequestMapping("queryCouponCount")
      @ResponseBody
      public  Long queryCouponCount(@RequestBody Coupon coupon) {
            long count = couponService.queryCouponCount(coupon);
            return count;
      }

      //优惠券新增
      @RequestMapping("saveCoupon")
      @ResponseBody
      public String saveCoupon(@RequestBody Coupon coupon){
            /*coupon.setId(UUID.randomUUID().toString().replaceAll("i",""));
            coupon.setStatus("未使用");
            Double cc = (100000+Math.random()*6);
            coupon.setCcount(cc.compareTo(cc));*/
            couponService.saveCoupon(coupon);
            return "添加成功";
      }

      //删除优惠券
      @RequestMapping("delCoupon")
      @ResponseBody
      public String delCoupon(@RequestParam String id){
            couponService.delCoupon(id);
            return "删除成功";
      }

      //修改回显
      @RequestMapping("queryAllCouponById")
      @ResponseBody
      public Coupon queryAllCouponById(@RequestParam String id){
            Coupon coupon=couponService.queryAllCouponById(id);


            return coupon;
      }

      //跳转发货页面  修改回显
      @RequestMapping("queryAllOrderById")
      @ResponseBody
      public Order queryAllOrderById(@RequestParam String orderId){
            Order order = couponService.queryAllOrderById(orderId);

            return order;
      }

      //跳转付款页面  修改回显

      @RequestMapping("queryTuikUAn")
      @ResponseBody
      public Order queryTuikUAn(@RequestParam String orderId){
            Order ordera = couponService.queryTuikUAn(orderId);

            return ordera;
      }

      //修改
      @RequestMapping("editCoupon")
      @ResponseBody
      public String editCoupon(@RequestBody Coupon coupon){
            couponService.editCoupon(coupon);
            return "修改成功";
      }

      //订单列表分页列表
      @RequestMapping("queryOrderList")
      @ResponseBody
      public List<Order> queryOrderList(@RequestBody Order order, @RequestParam Integer start, @RequestParam Integer limit) {
            List<Order> list = couponService.queryOrderList(order,start,limit);
            return list;
      }
      @RequestMapping("queryOrderCount")
      @ResponseBody
      public  Long queryOrderCount(@RequestBody Order order) {
            long count = couponService.queryOrderCount(order);
            return count;
      }

      //发货（修改）
      @RequestMapping("editOrder")
      @ResponseBody
      public String editOrder(@RequestBody Order order){
            couponService.editOrder(order);
            return "发货成功";
      }

      //退款成功
      @RequestMapping("editOrder666")
      @ResponseBody
      public String editOrder666(@RequestBody Order order){
            couponService.editOrder666(order);
            return "退款成功";
      }

      //获取订单详情
      @RequestMapping("getOrdersShow")//循环数据
      @ResponseBody
      public List<OrderItem> getOrdersShow(){
            List<OrderItem> orders = couponService.getOrdersShow();

            return orders;
      }

      //获取物流
      @RequestMapping("getOrdersShow1")
      @ResponseBody
      public List<Order> getOrdersShow1(){

            List<Order> order1 = couponService.getOrdersShow1();//物流信息


            return order1;
      }

      //获取订单详情
      @RequestMapping("getOrdersShow2")
      @ResponseBody
      public  List<OrderShipping> getOrdersShow2(){

            List<OrderShipping> order2 = couponService.getOrdersShow2();//买家信息

            return order2;
      }













}
