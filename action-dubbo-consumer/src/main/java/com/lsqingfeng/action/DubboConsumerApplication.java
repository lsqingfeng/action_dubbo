package com.lsqingfeng.action;


import com.lsqingfeng.action.dubbo.api.DubboApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
@EnableDubbo
class DubboConsumerApplication {

    // 这里要去掉url参数，会从nacos中自动获取地址，否则相当于是直连，不会注册到nocos
    @Reference(version = "1.0.0")
    private DubboApi dubboApi;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            log.info(dubboApi.test("mercyblitz"));
        };
    }
}
