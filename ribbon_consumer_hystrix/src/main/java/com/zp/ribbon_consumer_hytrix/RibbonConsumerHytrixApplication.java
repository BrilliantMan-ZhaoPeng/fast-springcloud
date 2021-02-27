package com.zp.ribbon_consumer_hytrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//可以用于所有的注册中心
//@EnableDiscoveryClient
//只用于Eureka注册中心
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker//开启断路器功能
//@SpringCloudApplication 或者直接使用这个注解，上面三个都不需要写了
public class RibbonConsumerHytrixApplication {
    //注入restTemplate
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerHytrixApplication.class, args);
    }
}
