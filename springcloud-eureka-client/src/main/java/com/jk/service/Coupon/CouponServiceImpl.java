package com.jk.service.Coupon;



import com.jk.mapper.CouponMapper;
import com.jk.model.Coupon;
import com.jk.model.Order;
import com.jk.model.OrderItem;
import com.jk.model.OrderShipping;
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

    @Override
    public List<Order> queryOrderList(Order order, Integer start, Integer pageSize) {
        return couponMapper.queryOrderList(order,(start-1)*pageSize,pageSize);
    }

    @Override
    public long queryOrderCount(Order order) {
        return couponMapper.queryOrderCount(order);
    }

    @Override
    public Order queryAllOrderById(String orderId) {
        return couponMapper.queryAllOrderById(orderId);
    }

    @Override
    public void editOrder(Order order) {
        couponMapper.editOrder(order);
    }

    @Override
    public List<OrderItem> getOrdersShow() {
        return couponMapper.getOrdersShow();
    }

    @Override
    public List<Order> getOrdersShow1() {
        return couponMapper.getOrdersShow1();
    }

    @Override
    public List<OrderShipping> getOrdersShow2() {
        return couponMapper.getOrdersShow2();
    }

    @Override
    public Order queryTuikUAn(String orderId) {
        return couponMapper.queryTuikUAn(orderId);
    }

    @Override
    public void editOrder666(Order order) {
        couponMapper.editOrder666(order);
    }


}
