package com.yin.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yin.springcloud.entity.CommonResult;
import com.yin.springcloud.entity.Payment;
import com.yin.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 14:36 2020/11/6
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalHandler")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentFeignService;
    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String getPaymentOk(@PathVariable("id") Integer id){
        return paymentFeignService.create(id);
    }
    @GetMapping(value = "/consumer/payment/hystrix/error/{id}")
//    @HystrixCommand(fallbackMethod = "infoHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String getPaymentError(@PathVariable("id") Integer id){
        int k=10/0;//Hystrix服务降级，保护服务
        return paymentFeignService.createrror(id);
    }
    public String infoHandler(Integer id){
        return "Hystrix Success!"+id;
    }
    public String globalHandler(){
        return "全局Hystrix Success!";
    }
}
