package com.example.biddingmanagement.lang;

import lombok.Data;

import java.io.Serializable;
/**
 * @program: spbtest
 * @ClassName Result
 * @description: 封装类，返回前端数据
 * @author: hj
 * @create: 2023-09-21
 * @Version 1.0
 **/
@Data
public class Result implements Serializable {
    //响应码
    private int code;
    //响应信息
    private String msg;
    //响应数据
    private Object data;

    /**
     * @Description: 传入成功获取的数据
     * @Date 15:15 2023/9/21
     * @Param data
     * @return Result
     **/
    public static Result succ(Object data) {
        return succ(200, "操作成功", data);
    }
    /**
     * @Description 自定义成功操作编码，信息，数据
     * @Date 15:18 2023/9/21
     * @Param int code, String msg, Object data
     * @return Result
     **/
    public static Result succ(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    /**
     * @Description: 传入操作失败的信息提示
     * @Date 15:15 2023/9/21
     * @Param msg
     * @return Result
     **/
    public static Result fail(String msg) {
        return fail(400, msg, null);
    }
    /**
     * @Description 自定义失败操作编码，信息，数据
     * @Date 15:18 2023/9/21
     * @Param int code, String msg, Object data
     * @return Result
     **/
    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}
