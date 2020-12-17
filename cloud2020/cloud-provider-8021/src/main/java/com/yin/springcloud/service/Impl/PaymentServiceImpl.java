package com.yin.springcloud.service.Impl;

import com.yin.springcloud.dao.PaymentDao;
import com.yin.springcloud.entity.Payment;
import com.yin.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 10:57 2020/11/6
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }
}
