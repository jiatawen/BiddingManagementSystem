package com.jiata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiata.entity.TUser;
import com.jiata.service.TUserService;
import com.jiata.mapper.TUserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Jiata
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2023-10-09 23:06:41
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService{
    @Resource
    private TUserMapper userMapper;

    @Override
    public List<TUser> getAllUser() {
        List<TUser> tUsers = userMapper.selectAll();
        return tUsers;
    }

    @Override
    public TUser getUserById(Integer id) {
        TUser user = userMapper.selectAllByPeopleId(id);
        return user;
    }

    @Override
    public Integer insertUser(TUser user) {
        Integer flag = userMapper.insertUser(user);
        return flag;
    }

    @Override
    public boolean delUserById(Integer id) {
        boolean flag = userMapper.delByPeopleIdBoolean(id);
        return flag;
    }

    @Override
    public boolean modifyUser(TUser user) {
        boolean flag = userMapper.modifyUser(user);
        return flag;
    }

    @Override
    public List<TUser> getByLegalName(String legalName) {
        List<TUser> users = userMapper.selectAllBylegalName(legalName);
        return users;
    }
}




