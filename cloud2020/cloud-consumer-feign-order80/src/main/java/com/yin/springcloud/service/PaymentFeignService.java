package com.yin.springcloud.service;

import com.yin.springcloud.entity.CommonResult;
import com.yin.springcloud.entity.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 16:24 2020/11/18CLOUD-PAYMENT-SERVICE
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Integer id);
}
