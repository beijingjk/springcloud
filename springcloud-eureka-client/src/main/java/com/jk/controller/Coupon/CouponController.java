package com.jk.controller.Coupon;


import com.jk.model.Coupon;
import com.jk.model.PetType;
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

      //修改
      @RequestMapping("editCoupon")
      @ResponseBody
      public String editCoupon(@RequestBody Coupon coupon){
            couponService.editCoupon(coupon);
            return "修改成功";
      }






}
