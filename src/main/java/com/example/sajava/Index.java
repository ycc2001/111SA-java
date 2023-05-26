package com.example.sajava;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Index {
    public static void main(String[] args) {

    }
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
