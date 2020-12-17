package com.yin.springcloud.controller;

import com.yin.springcloud.entity.CommonResult;
import com.yin.springcloud.entity.Payment;
import com.yin.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 14:36 2020/11/6
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")

    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id){
        return paymentFeignService.getPaymentById(id);
    }
}
