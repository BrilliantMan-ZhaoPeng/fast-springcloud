package com.zp.ribbon_consumer_hytrix.service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.hystrix.FallbackHandler;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaopeng
 * @create 2021-02-25 14:45
 */
@Service
public class HelloService {
    @Value("${server.port}")
    private int port;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(ignoreExceptions = ArithmeticException.class,fallbackMethod = "helloFallback")
    public String hello() {
        return restTemplate.getForEntity("http://API-SERVICE/hello",String.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "hellowithErrorFallback")
    public String hellowithError() {
        throw  new RuntimeException("hahahaha error..");
//        return restTemplate.getForEntity("http://API-SERVICE/hello-error",String.class).getBody();
    }

    private String hellowithErrorFallback(Throwable e) {
        System.err.println(e.toString());
        System.err.println("messsage:"+e.getMessage());
        return e.getMessage();
    }

    //fallback方法
    private String helloFallback() {
        return "error";
    }
}
