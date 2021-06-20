package com.ry.springcloud.service;

import com.ry.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: ruyi yang
 * @date 2021/6/19 20:25
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
