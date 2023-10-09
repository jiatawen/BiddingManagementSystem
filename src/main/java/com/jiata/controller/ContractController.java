package com.jiata.controller;

import com.jiata.contract.TContract;
import com.jiata.service.impl.TContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContractController {

    @Autowired
    private TContractServiceImpl contractService;
    @GetMapping("/hello")
    public String printHello(){
        return "hello1";
    }

    @GetMapping("/getAll")
    public List<TContract> getAllContract(){
        return contractService.getAllContract();
    }
}
