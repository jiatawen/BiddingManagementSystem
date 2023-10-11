package com.jiata.controller;

import com.jiata.entity.TUser;
import com.jiata.service.impl.TUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TUserServiceImpl userService;

    @GetMapping("/getAll")
    public List<TUser> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping("/getById")
    public TUser getUserById(Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/insert")
    public Integer insertUser(TUser user){
        return userService.insertUser(user);
    }

    @PostMapping("/del")
    public boolean delUser(Integer id){
        return userService.delUserById(id);
    }

    @PostMapping("/modify")
    public boolean modifyUser(TUser user){
        return userService.modifyUser(user);
    }

    @PostMapping("/searchName")
    public List<TUser> getByName(String legalName){
        return userService.getByLegalName(legalName);
    }
}
