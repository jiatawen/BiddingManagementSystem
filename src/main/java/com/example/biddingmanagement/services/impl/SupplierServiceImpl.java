package com.example.biddingmanagement.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.biddingmanagement.entity.Supplier;
import com.example.biddingmanagement.mapper.SupplierMapper;
import com.example.biddingmanagement.mapper.SupplierTypeMapper;
import com.example.biddingmanagement.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spbtest
 * @ClassName SupplierServiceImpl
 * @description: 服务层实现类
 * @author: hj
 * @create: 2023-09-21
 * @Version 1.0
 **/
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
    @Autowired
    private SupplierTypeMapper supplierTypeMapper;

//    public List<String> getName(){
//        List<String> list = supplierTypeMapper.getName();
//        return list;
//    }
}
