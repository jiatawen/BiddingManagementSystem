package com.example.biddingmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: spbtest
 * @ClassName Supplier
 * @description: 供应商实体类
 * @author: hj
 * @create: 2023-09-21
 * @Version 1.0
 **/
@TableName
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    //供应商编号
    private int id;
    //供应商名称
    private String name;
    //供应商地址
    private String address;
    //供应商联系方式
    private String tel;
    //供应商类型
    private String type;
    //供应商注册资金
    private double money;

}
