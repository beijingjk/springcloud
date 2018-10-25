package com.jk.service.Coupon;



import com.jk.mapper.CouponMapper;
import com.jk.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponServiceApi{
          @Autowired
          private CouponMapper couponMapper;


    @Override
    public List<Coupon> queryCouponList(Coupon coupon, Integer start, Integer pageSize) {
        return couponMapper.queryCouponList(coupon,(start-1)*pageSize,pageSize);
    }

    @Override
    public long queryCouponCount(Coupon coupon) {
        return couponMapper.queryCouponCount(coupon);
    }

    @Override
    public void saveCoupon(Coupon coupon) {
        couponMapper.saveCoupon(coupon);
    }

    @Override
    public void delCoupon(String id) {
        couponMapper.delCoupon(id);
    }

    @Override
    public Coupon queryAllCouponById(String id) {
        return couponMapper.queryAllCouponById(id);
    }

    @Override
    public void editCoupon(Coupon coupon) {
        couponMapper.editCoupon(coupon);
    }
}
