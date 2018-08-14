package com.lzf.springcloud;

import com.lzf.myrule.MySelfRule;
import com.lzf.myrule.MySelfRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DeptConsumer_Feign_80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign_80_App.class, args);
    }
}
