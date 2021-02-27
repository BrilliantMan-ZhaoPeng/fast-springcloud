package com.zp.ribbon_consumer_hytrix.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * @author zhaopeng
 * @create 2021-02-23 17:43
 */
@RestController
public class HelloController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://API-SERVICE/hello",String.class).getBody();
    }
}
