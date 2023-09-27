package com.example.biddingmanagement.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.biddingmanagement.entity.Supplier;
import com.example.biddingmanagement.lang.Result;
import com.example.biddingmanagement.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spbtest
 * @ClassName SupplierController
 * @description: 供应商控制层
 * @author: hj
 * @create: 2023-09-21
 * @Version 1.0
 **/
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    //注入
    @Autowired
    SupplierService supplierService;

    @PostMapping("/add")
    /**
     * @Description 添加供应商
     * @Date 10:38 2023/9/21
     * @Param [supplier]
     * @return com.example.demo.lang.Result
     **/
    public Result add(@RequestBody Supplier supplier){
        boolean save = supplierService.save(supplier);
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
        List<Supplier> list = supplierService.list();
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
        boolean b = supplierService.removeById(id);
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
        List<Supplier> suppliers = supplierService
                    .getBaseMapper()
                    .selectList(new QueryWrapper<Supplier>()
                            .eq("name", name));
            if (suppliers != null){
                return Result.succ(suppliers);
            }else {
                return Result.fail("未找到该条数据");
            }

    }

    @PostMapping("/update")
    /**
     * @Description: 更新数据
     * @Date 11:00 2023/9/21
     * @Param [supplier]
     * @return com.example.demo.lang.Result
     **/
    public Result update(@RequestBody Supplier supplier){
//         supplierService.updateById(supplier);
        boolean b = supplierService.saveOrUpdate(supplier);
        if(b==true){
            return Result.succ(b);
        }else {
            return Result.fail("修改该条数据失败");
        }
    }

}
