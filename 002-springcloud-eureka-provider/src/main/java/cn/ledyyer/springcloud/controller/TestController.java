package cn.ledyyer.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/test")
    public String test(){
        return "使用Eureka的服务提供者";
    }
}
