package com.jk.mapper;

import com.jk.model.Coupon;
import com.jk.model.Order;
import com.jk.model.OrderItem;
import com.jk.model.OrderShipping;
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

    long queryOrderCount(@Param("o")Order order);

    List<Order> queryOrderList(@Param("o")Order order,@Param("start") Integer start, @Param("pageSize") Integer pageSize);


    Order queryAllOrderById(String orderId);

    void editOrder(Order order);

    List<OrderItem> getOrdersShow();

    List<Order> getOrdersShow1();

    List<OrderShipping> getOrdersShow2();

    Order queryTuikUAn(@Param("orderId")String orderId);

    void editOrder666(Order order);

}
