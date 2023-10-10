package com.jiata.controller;

import com.jiata.entity.TContract;
import com.jiata.service.impl.TContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private TContractServiceImpl contractService;

    @GetMapping("/getAll")
    public List<TContract> getAllContract(){
        return contractService.getAllContract();
    }
}
