package com.example.biddingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestController {
    @RequestMapping("/helloword")
    public String helloWord(){
        return "Hello Word !!!";
    }
}
