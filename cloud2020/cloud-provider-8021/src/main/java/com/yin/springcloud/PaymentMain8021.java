package com.yin.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 尹诚
 * @parm
 * @date 2020/11/6 10:06
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yin.springcloud.dao")
public class PaymentMain8021 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8021.class,args);
    }
}
