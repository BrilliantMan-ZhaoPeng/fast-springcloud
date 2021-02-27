package com.zp.feign_consumer.service.fallback;
import com.zp.feign_consumer.service.HelloService;
import org.springframework.stereotype.Component;
/**
 * @author zhaopeng
 * @create 2021-02-25 19:52
 */
//@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello() {
        return "fallback error...";
    }

    @Override
    public String hello_error() {
        return "hello_error has error...";
    }
}
