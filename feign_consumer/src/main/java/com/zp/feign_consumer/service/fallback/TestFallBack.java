package com.zp.feign_consumer.service.fallback;

import com.zp.feign_consumer.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhaopeng
 * @create 2021-02-27 10:44
 */
@Component
public class TestFallBack implements FallbackFactory<HelloService> {
    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String hello() {
                return "hello()---"+throwable.getMessage();
            }

            @Override
            public String hello_error() {
                return "hello_error"+throwable.getMessage();
            }
        };
    }
}
