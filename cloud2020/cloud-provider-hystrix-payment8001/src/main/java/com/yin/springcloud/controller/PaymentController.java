package com.yin.springcloud.controller;

import com.yin.springcloud.entity.CommonResult;
import com.yin.springcloud.entity.Payment;
import com.yin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 11:01 2020/11/6
 */
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String create(@PathVariable("id") Integer id){

        return paymentService.paymentInfoOk(id);
    }
    @GetMapping(value = "/payment/hystrix/error/{id}")
    public String createrror(@PathVariable("id") Integer id){
        int i=0;
        log.info("错过演示结果计数：");
        return paymentService.paymentInfoError(id);
    }

}
