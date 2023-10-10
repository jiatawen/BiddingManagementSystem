package com.jiata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class HtmlController {
    @GetMapping("/contract")
    public String showContractHtml(){
        return "../html/contract.html";
    }
}
