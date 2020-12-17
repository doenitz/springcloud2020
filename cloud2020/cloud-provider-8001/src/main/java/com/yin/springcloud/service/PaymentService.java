package com.yin.springcloud.service;

import com.yin.springcloud.entity.Payment;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 10:56 2020/11/6
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Integer id);
}
