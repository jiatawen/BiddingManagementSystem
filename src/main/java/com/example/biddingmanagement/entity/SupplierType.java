package com.example.biddingmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: spbtest
 * @ClassName SupplierType
 * @description:
 * @author: hj
 * @create: 2023-09-23
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("suppliertype")
public class SupplierType {
    @TableId
    private int id;
    //供应方类型
    private String text;
    //类型描述
    private String memo;
}
