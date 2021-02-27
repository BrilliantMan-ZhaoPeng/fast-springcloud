package com.zp.api_service.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author zhaopeng
 * @create 2021-02-22 23:31
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private int port;

    @RequestMapping("/hello")
    public String hello() {
        return "port:"+port+"---hello zp...";
    }


    @RequestMapping("/hello-error")
    public String hello_error() {
        System.err.println("执行hello_error()");
        int i = 1 / 0;
        return "error";
    }
}
