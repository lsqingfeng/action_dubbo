package com.lsqingfeng.action.dubbo.consumer;

import com.lsqingfeng.action.dubbo.api.DubboApi;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo")
public class ConsumerController {

    @Reference(version = "1.0.0")
    private DubboApi dubboApi;

    @RequestMapping("/test")
    public String test(){
        return dubboApi.test("hahaha");
    }
}
