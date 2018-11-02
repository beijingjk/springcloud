package com.jk.controller.Coupon;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.model.*;
import com.jk.service.Coupon.CouponServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("yx")
public class CouponController {
       @Autowired
       private CouponServiceApi  couponService;



       //跳转优惠券列表
       @RequestMapping("toCoupons")
       public String toCoupons(){
           return "toCouponList";
       }

       //优惠券分页列表 queryCoupon
       @RequestMapping("/queryCoupon")
       @ResponseBody
       public Map<String,Object> queryPetPage(Coupon coupon, Integer start, Integer limit){


           List<Coupon> list = new ArrayList<Coupon>();

           Map<String,Object> map =new HashMap<String,Object>();


           if(start==null){
               start=1;
           }

           try {
               list=couponService.queryCouponList(coupon,start,limit);
               long count = couponService.queryCouponCount(coupon);
               map.put("count", count);
               map.put("data",list);
               map.put("code",0);
               map.put("msg","");

           } catch (Exception e) {

               e.printStackTrace();
           }
           return map;
       }

       //跳转新增优惠券页面
       @RequestMapping("toAddCoupon")
       public String toAddCoupon(){
           return "toAddCoupon";
       }

       //优惠券新增
      @RequestMapping("saveCoupon")
      @ResponseBody
      public String saveCoupon(Coupon coupon){
          coupon.setId(UUID.randomUUID().toString().replaceAll("-",""));
          coupon.setStatus("待领取");
          Double cc = (100000+Math.random()*6);
          coupon.setCnumber(cc.toString());
          couponService.saveCoupon(coupon);
           return "添加成功";
      }

      //删除优惠券
    @RequestMapping("delCoupon")
    @ResponseBody
    public String delCoupon(String id){
        couponService.delCoupon(id);
           return "删除成功";
    }

    //修改回显
    @RequestMapping("queryAllCouponById")
    public String queryAllCouponById(String id, HttpServletRequest request){
        Coupon coupon=couponService.queryAllCouponById(id);

        request.setAttribute("coupon",coupon);
           return "ByIdToCoupon";
    }

    //修改
    @RequestMapping("editCoupon")
    @ResponseBody
    public String editCoupon(Coupon coupon){
        couponService.editCoupon(coupon);
           return "修改成功";
    }

    //跳转订单管理页面
    @RequestMapping("toOrders")
    public String toOrders(){
          return "toOrders";
    }

    //查询订单分页列表  queryOrder
    @RequestMapping("queryOrder")
    @ResponseBody
    public Map<String,Object> queryOrder(Order order, Integer start, Integer limit){


        List<Order> list =new ArrayList<Order>();

        Map<String,Object> map =new HashMap<String,Object>();


        if(start==null){
            start=1;
        }

        try {
            list=couponService.queryOrderList(order,start,limit);
            long count = couponService.queryOrderCount(order);
            map.put("count", count);
            map.put("data",list);
            map.put("code",0);
            map.put("msg","");

        } catch (Exception e) {

            e.printStackTrace();
        }
        return map;
    }


    //跳转发货页面  修改回显
    @RequestMapping("queryAllOrderById")
    public String queryAllOrderById(String orderId, HttpServletRequest request){
        Order order = couponService.queryAllOrderById(orderId);
        request.setAttribute("order",order);
        return "ByIdToOrder";
    }
    //跳转退款页面
    @RequestMapping("queryTuikUAn")
    public String queryTuikUAn(String orderId, HttpServletRequest request){
        Order ordera = couponService.queryTuikUAn(orderId);
        request.setAttribute("ordera",ordera);
           return "queryTuikUAn";
    }



    //获取订单详情
    @RequestMapping("getOrdersShow")
    public String getOrdersShow(HttpServletRequest request){
        List<OrderItem> orders = couponService.getOrdersShow();//循环数据
        List<Order> order1 = couponService.getOrdersShow1();//物流信息
        List<OrderShipping> order2 = couponService.getOrdersShow2();//买家信息
        request.setAttribute("orders",orders);
        request.setAttribute("order1",order1);
        request.setAttribute("order2",order2);
        return "getOrdersShow";
    }

    //发货（修改）
    @RequestMapping("editOrder")
    @ResponseBody
    public String editOrder(Order order){
        couponService.editOrder(order);
           return "发货成功";
    }

    //退款成功
    @RequestMapping("editOrder666")
    @ResponseBody
    public String editOrder666(Order order){
        couponService.editOrder666(order);
        return "退款成功";
    }
















}
