package com.yin.springcloud.service;

import com.yin.springcloud.entity.CommonResult;
import com.yin.springcloud.entity.Payment;
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
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String create(@PathVariable("id") Integer id);
    @GetMapping(value = "/payment/hystrix/error/{id}")
    public String createrror(@PathVariable("id") Integer id);
}
