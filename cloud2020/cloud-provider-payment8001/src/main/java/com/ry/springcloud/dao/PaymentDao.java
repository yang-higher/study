package com.ry.springcloud.dao;

import com.ry.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: ruyi yang
 * @date 2021/6/19 19:52
 */
@Mapper
// @Repository
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
