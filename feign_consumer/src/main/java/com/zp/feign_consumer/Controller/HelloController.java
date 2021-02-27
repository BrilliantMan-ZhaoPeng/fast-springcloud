package com.zp.feign_consumer.Controller;
import com.zp.feign_consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author zhaopeng
 * @create 2021-02-25 17:41
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping("/hello-error")
    public String hello_error() {
        return helloService.hello_error();
    }

}
