package com.example.serviceribbon.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-hi")
    public Object hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}
