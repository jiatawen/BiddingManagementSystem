package com.example.biddingmanagement.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.biddingmanagement.entity.SupplierType;
import com.example.biddingmanagement.lang.Result;
import com.example.biddingmanagement.services.SupplierTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spbtest
 * @ClassName SupplierTypeTypeController
 * @description:
 * @author: hj
 * @create: 2023-09-23
 * @Version 1.0
 **/
@RestController
@RequestMapping("/suppliertype")
public class SupplierTypeController {
    //注入
    @Autowired
    SupplierTypeService service;
    @PostMapping("/add")
    /**
     * @Description 添加供应商
     * @Date 10:38 2023/9/21
     * @Param [SupplierType]
     * @return com.example.demo.lang.Result
     **/
    public Result add(@RequestBody SupplierType suppliertype){
        boolean save = service.save(suppliertype);
        if (save==true){
            return Result.succ(save);
        }else {
            return Result.fail(400,"添加供应商失败",false);
        }
    }

    @GetMapping("/getall")
    /**
     * @Description: 查询所有数据
     * @Date 10:57 2023/9/21
     * @Param []
     * @return com.example.demo.lang.Result
     **/
    public Result getAll(){
        List<SupplierType> list = service.list();
        return Result.succ(list);
    }

    @GetMapping("/delete")
    /**
     * @Description: 删除该条数据
     * @Date 10:58 2023/9/21
     * @Param [id]
     * @return com.example.demo.lang.Result
     **/
    public Result delete(@RequestParam int id){
        System.out.println(id);
        boolean b = service.removeById(id);
        if(b== true){
            return Result.succ("删除成功");
        }else {
            return Result.fail("删除该条数据失败");
        }
    }

    @GetMapping("/getone")
    /**
     * @Description: 查找一条记录
     * @Date 11:00 2023/9/21
     * @Param [name]
     * @return com.example.demo.lang.Result
     **/
    public Result getByName(@RequestParam String name){
        List<SupplierType> suppliertype = service
                .getBaseMapper()
                .selectList(new QueryWrapper<SupplierType>()
                        .eq("text", name));
        if (suppliertype != null){
            return Result.succ(suppliertype);
        }else {
            return Result.fail("未找到该条数据");
        }

    }

    @PostMapping("/update")
    /**
     * @Description: 更新数据
     * @Date 11:00 2023/9/21
     * @Param [SupplierType]
     * @return com.example.demo.lang.Result
     **/
    public Result update(@RequestBody SupplierType suppliertype){
//         service.updateById(SupplierType);
        boolean b = service.updateById(suppliertype);
        if(b==true){
            return Result.succ(b);
        }else {
            return Result.fail("修改该条数据失败");
        }
    }


}
