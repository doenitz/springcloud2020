package com.yin.springcloud.controller;

import com.yin.springcloud.entity.CommonResult;
import com.yin.springcloud.entity.Payment;
import com.yin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("*****插入结果："+result);
        log.info("******参数："+payment.getId()+payment.getSerial()+"*********");
        return new CommonResult(200,"插入成功,端口号："+serverPort,result);
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Integer id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("*****查询"+payment);
        return new CommonResult(200,"查询成功,查询端口："+serverPort,payment);
    }
}
