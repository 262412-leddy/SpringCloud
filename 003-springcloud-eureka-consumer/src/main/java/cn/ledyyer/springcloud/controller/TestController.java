package cn.ledyyer.springcloud.controller;

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
        String res = restTemplate.getForEntity("http://003-SPRINGCLOUD-EUREKA-PROVIDER/test",String.class).getBody();
        model.addAttribute("message",res);
        return "index";
    }
}
