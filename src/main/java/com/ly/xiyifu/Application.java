package com.ly.xiyifu;

/**
 * 文件名称： Application
 * <p>
 * 包路径： com.ly.xiyifu
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/25 - 13:40
 * <p>
 * 修改记录：
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:transaction.xml")
@SpringBootApplication(scanBasePackages = ("com.ly"))
@EnableFeignClients(basePackages = "com.ly.rpc.service")
@MapperScan("com.ly.xiyifu.dao")
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
