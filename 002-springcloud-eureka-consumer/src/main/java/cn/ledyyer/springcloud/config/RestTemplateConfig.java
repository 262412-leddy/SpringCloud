package cn.ledyyer.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced  //用于标记当前的RestTemplate使用Ribbon的负载均衡范文服务的提供者
                    // 使用了Eureka注册中心后必须使用这个注解否则无法正常获取服务，默认情况Ribbon的负载均衡是轮询
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
