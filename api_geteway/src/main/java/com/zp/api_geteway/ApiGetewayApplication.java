package com.zp.api_geteway;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableZuulProxy//
@SpringCloudApplication//这里需要注意，不仅仅是需要springbootApplication
//还需要@EnableDiscoveryClient  @EnableCircuitBreaker
public class ApiGetewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGetewayApplication.class, args);
    }
}
