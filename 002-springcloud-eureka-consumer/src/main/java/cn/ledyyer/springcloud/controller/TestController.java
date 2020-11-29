package cn.ledyyer.springcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Controller
public class TestController {
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test")
    public String test(Model model){
        /*通过注册中心发现服务并访问服务
        * 002-SPRINGCLOUD-EUREKA-PROVIDER就是服务在注册中心的名称（不分大小写）
        * SpringCloud会根据这个服务名到注册中心获取当前服务所在IP+端口号，然后利用RestTemplate访问服务*/
        String res = restTemplate.getForEntity("http://002-SPRINGCLOUD-EUREKA-PROVIDER/test",String.class).getBody();
        model.addAttribute("message",res);
        return "index";
    }
}
