package cn.ledyyer.springcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    //将RestTemplate对象交给Spring管理
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test")
    public String test(){
        /*
        * RestTemplate是一个基于Http协议的一个工具对象，我们可以利用这个对象，以Http发送请求到某个指定的Web服务器中
        * 在Spring cloud中，可以利用这个对象来访问服务提供者
        * 这个对象可以new，因为可以交给Spring创建（加以交给Spring）
        * */


//        RestTemplate restTemplate = new RestTemplate();

        /*
        * getForEntity 方法 是以get方式提交请求，访问web服务器中的某个请求对应着另外一个工程中的
        * @GetMapping 或 @RequestMapping
        * 参数 1 需要访问的具体请求路径
        * 参数 2 本次请求以后服务器返回的数据类型
        * 参数 3 可变长度的Object类型数据，表示本次请求中的url参数数据
        *
        * 返回值：ResponseEntity对象，这个对象封装着本次请求的响应实体，这个对象中，我们可以获取本次请求的状态码，头文件信息，以及具体响应数据
        *
        * 注意：由于SpringCloud返回的数据全部是Rest风格的数据，因此，所有的数据类型全部都是String类型的json数据格式
        * 可以根据具体的数据格式来执行
        *
        * */
        ResponseEntity<String> result =  restTemplate.getForEntity("http://localhost:8081/test",String.class);
        System.out.println(result.getStatusCode());//获取响应编码  200，404
        System.out.println(result.getHeaders());//获取响应头
        String body = result.getBody();//获取具体的响应数据，具体类型取决于getForEntity方法的参数2
        return "第一个SpringCloud的服务消费者------"+body;
    }
}
