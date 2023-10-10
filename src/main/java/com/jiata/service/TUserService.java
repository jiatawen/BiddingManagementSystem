package com.jiata.service;

import com.jiata.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiata.mapper.TUserMapper;
import jakarta.annotation.Resource;

import java.util.List;

/**
* @author Jiata
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-10-09 23:06:41
*/
public interface TUserService extends IService<TUser> {
    public List<TUser> getAllUser();
    public TUser getUserById(Integer id);
    public Integer insertUser(TUser user);
    public boolean delUserByid(Integer id);

    public boolean modifyUser(TUser user);
}
