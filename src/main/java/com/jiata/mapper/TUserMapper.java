package com.jiata.mapper;

import com.jiata.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jiata
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-10-09 23:06:41
* @Entity com.jiata.contract.TUser
*/

@Mapper
public interface TUserMapper extends BaseMapper<TUser> {
    public TUser selectAllByPeopleId(Integer id);

    public List<TUser> selectAll();
    public Integer insertUser(TUser user);

    public boolean delByPeopleIdBoolean(Integer id);

    public boolean modifyUser(TUser user);

    public List<TUser> selectAllBylegalName(String legalName);
}




