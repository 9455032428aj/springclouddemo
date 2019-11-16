package com.example.servicehi;

import com.example.servicehi.io.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public Object home(@RequestParam String name) {
        Map<String, Object> map = new HashMap<>();
        User user = new User(1, "fys");
        String s = "hi " + name + ", i'm from port " + port;
        map.put("user", user);
        map.put("str", s);
        return map;
    }
}
