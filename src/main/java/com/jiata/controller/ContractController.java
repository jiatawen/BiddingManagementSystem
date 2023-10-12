package com.jiata.controller;

import com.jiata.entity.TContract;
import com.jiata.service.impl.TContractServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Resource
    private TContractServiceImpl contractService;

    @GetMapping("/getAll")
    public List<TContract> getAllContract(){
        return contractService.getAllContract();
    }

    @PostMapping("/getById")
    public TContract getContractById(Integer id){
        return contractService.getContractById(id);
    }

    @PostMapping("/insert")
    public Integer insertContract(TContract contract){
        return contractService.insertContract(contract);
    }

    @PostMapping("/del")
    public boolean delContract(Integer id){
        return contractService.delContract(id);
    }

    @PostMapping("/modify")
    public boolean modifyContract(TContract contract){
        return contractService.modifyContract(contract);
    }

    @PostMapping("/searchName")
    public List<TContract> getByName(String title){
        return contractService.getByName(title);
    }

    @PostMapping("/findUid")
    public boolean findByUid(String uid){
        return contractService.findByUid(uid);
    }
}