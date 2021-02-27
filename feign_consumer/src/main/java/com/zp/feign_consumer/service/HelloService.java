package com.zp.feign_consumer.service;
import com.zp.feign_consumer.service.fallback.HelloServiceFallback;
import com.zp.feign_consumer.service.fallback.TestFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author zhaopeng
 * @create 2021-02-25 17:37
 */
@FeignClient(value = "api-service",fallback = HelloServiceFallback.class)//服务名 ：这里服务名不区分大小写
public interface HelloService {
    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/hello-error")
    public String hello_error();
}

