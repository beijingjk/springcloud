package com.jk.mapper;

import com.jk.model.Coupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponMapper {


    

    long queryCouponCount(@Param("c")Coupon coupon);

    List<Coupon> queryCouponList(@Param("c")Coupon coupon, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    void saveCoupon(Coupon coupon);

    void delCoupon(String id);

    Coupon queryAllCouponById(String id);

    void editCoupon(Coupon coupon);

}
