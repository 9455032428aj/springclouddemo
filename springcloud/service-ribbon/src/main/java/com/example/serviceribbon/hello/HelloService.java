package com.example.serviceribbon.hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    //断路器的注解配置，当无法调用以下方法时，就会调用自定义的hiError方法
    @HystrixCommand(fallbackMethod = "hiError")
    public Object hiService(String name) {
//        ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://SERVICE-HI/hi?name=" + name, Object.class);
        Object forObject = restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, Object.class);
        return forObject;
    }

    public Object hiError(String name){
        return "hey " + name + ", there is something problem with hi page";
    }
}
