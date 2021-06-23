package com.ry.springcloud.service.impl;

import com.ry.springcloud.dao.PaymentDao;
import com.ry.springcloud.entities.Payment;
import com.ry.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: ruyi yang
 * @date 2021/6/19 20:26
 */
@Service
public class PaymentServiceImpl  implements PaymentService{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
