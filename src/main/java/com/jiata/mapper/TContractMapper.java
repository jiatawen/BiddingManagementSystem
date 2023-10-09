package com.jiata.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.jiata.contract.TContract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jiata
* @description 针对表【t_contract】的数据库操作Mapper
* @createDate 2023-10-09 22:01:06
* @Entity com.jiata.contract.TContract
*/
@Mapper
public interface TContractMapper extends BaseMapper<TContract> {

    List<TContract> selectAllContract();

}




