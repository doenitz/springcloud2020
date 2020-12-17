package com.yin.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 10:27 2020/11/19
 */
@Service
public class PaymentService {
    /**
     * @author 尹诚
     * @parm正常访问
     * @date 2020/11/19 10:30
     */
    public String paymentInfoOk(Integer id){
        return "线程池："+Thread.currentThread().getName()+";paymentOk+ID："+id;
    }
    /**
     * @author 尹诚
     * @parm报错
     * @date 2020/11/19 10:30
     */
    @HystrixCommand(fallbackMethod = "paymentInfoHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfoError(Integer id){
        int time=5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+";paymenterror我失败了+ID："+id+"耗时："+time;
    }
    public String paymentInfoHandler(Integer id){
        return "Hystrix线程池："+Thread.currentThread().getName()+";paymentInfoHandler+ID："+id;
    }
}
