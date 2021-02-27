package com.zp.ribbon_consumer_hytrix.controller;
import com.zp.ribbon_consumer_hytrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author zhaopeng
 * @create 2021-02-25 15:08
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hello")
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping(value = "/hello-error")
    public String hellowitherror() {
        return helloService.hellowithError();
    }
}
