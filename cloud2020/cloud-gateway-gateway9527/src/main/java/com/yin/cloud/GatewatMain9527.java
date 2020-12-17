package com.yin.cloud;

import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 19:44 2020/11/23
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewatMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewatMain9527.class,args);
    }
}
